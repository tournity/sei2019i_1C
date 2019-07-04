let jwt = require('jsonwebtoken');
let crypto = require('crypto');
const config = require('../config/config.js');
let AccountRepository = require('./account');

let generateRandomString = function(length) {
  return crypto
    .randomBytes(Math.ceil(length / 2))
    .toString('hex')
    .slice(0, length);
};

module.exports.generateCredentials = function(password) {
  let salt = generateRandomString(100);
  let encryptedPassword = crypto
    .createHash('SHA256')
    .update(password + salt)
    .digest('hex');
  return {
    encryptedPassword: encryptedPassword,
    salt: salt
  };
};

let diferenceBetweenDatesInMinutes = function(date1, date2) {
  return Math.round((date2 - date1) / (1000 * 3600));
};

module.exports.checkToken = async function(req) {
  let token = req.headers['x-access-token'] || req.headers['authorization'];
  if (token) {
    if (token.startsWith('Bearer ')) token = token.slice(7, token.length);
    let decoded = jwt.verify(token, config.secret);
    let account = await AccountRepository.findByEmail(decoded.email);
    if (
      account &&
      account.token == token &&
      diferenceBetweenDatesInMinutes(account.lastInteractionDate, Date.now()) <
        600
    ) {
      await account.update({ lastInteractionDate: Date.now() });
      return {
        id: account.id,
        type: account.type,
        name: account.name,
        email: account.email,
        status: account.status
      };
    } else {
      throw Error('Token unauthorized');
    }
  } else {
    throw Error('Auth token was not supplied');
  }
};

module.exports.createToken = async function(accountData) {
  let email = accountData.email;
  let password = accountData.password;
  if (email && password) {
    let account = await AccountRepository.findByEmail(email);

    let hash = crypto
      .createHash('SHA256')
      .update(password + account.salt)
      .digest('hex');

    if (hash === account.encryptedPassword) {
      let token = jwt.sign(
        {
          id: account.id,
          type: account.type,
          name: account.name,
          email: account.email,
          status: account.status
        },
        config.secret,
        { expiresIn: '24h' }
      );
      await account.update({ token: token, lastInteractionDate: Date.now() });
      return {
        user_data: {
          id: account.id,
          type: account.type,
          name: account.name,
          email: account.email,
          token: token,
          status: account.status
        }
      };
    } else {
      throw Error('Wrong password or email');
    }
  } else {
    throw Error('There is no user or email');
  }
};

module.exports.deleteToken = async function(accountData) {
  let user = await AccountRepository.findByEmail(accountData.email);
  await user.update({ token: null, connected: false });
};
