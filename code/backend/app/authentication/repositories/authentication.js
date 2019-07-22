let CryptographyAssistant = require('../assistants').CryptographyAssistant;
let AccountRepository = require('./account');

module.exports.checkToken = async function(token) {
  let decodedToken = CryptographyAssistant.getTokenInformation(token);
  let account = await AccountRepository.findById(decodedToken.id);
  let isValid =
    token == account.token &&
    CryptographyAssistant.isAllowedInteraction(account.lastInteractionDate);

  if (!isValid) throw Error('Token unauthorized');

  return account;
};

module.exports.createToken = async function(accountData) {
  const account = await AccountRepository.findByEmail(accountData.email);
  if (!account) throw Error('Wrong email');

  const encryptedPassword = CryptographyAssistant.encryptWithSHA2(
    accountData.password + account.salt
  );
  if (encryptedPassword === account.encryptedPassword) {
    const token = CryptographyAssistant.generateToken(accountData);
    await account.update({ token: token });
    return account;
  } else {
    throw Error('Wrong password');
  }
};

module.exports.deleteToken = async function(accountData) {
  let currentAccount = await AccountRepository.findByEmail(accountData.email);
  await currentAccount.update({ token: null });
};
