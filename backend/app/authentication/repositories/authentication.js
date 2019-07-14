let CryptographyAssistant = require('../assistants').CryptographyAssistant;
let AccountRepository = require('./account');

module.exports.checkToken = async function(token) {
  if (token) {
    let decoded = CryptographyAssistant.getTokenInformation(token);
    let account = await AccountRepository.findById(decoded.id);
    if (
      account &&
      account.token == token &&
      CryptographyAssistant.isAllowedInteraction(account.lastInteractionDate)
    ) {
      await account.update({ lastInteractionDate: Date.now() });
      return account;
    } else {
      throw Error('Token unauthorized');
    }
  } else {
    throw Error('Auth token was not supplied');
  }
};

module.exports.createToken = async function(accountData) {
  const email = accountData.email;
  const password = accountData.password;
  const account = await AccountRepository.findByEmail(email);
  if (!account) throw Error('Wrong email');
  const hash = CryptographyAssistant.encryptWithSHA2(password + account.salt);
  if (hash === account.encryptedPassword) {
    await account.update({
      token: accountData.token,
      lastInteractionDate: Date.now()
    });
    return account;
  } else {
    throw Error('Wrong password');
  }
};

module.exports.deleteToken = async function(accountData) {
  let currentAccount = await AccountRepository.findByEmail(accountData.email);
  await currentAccount.update({ token: null });
};
