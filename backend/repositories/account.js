const sequelize = require('../models').sequelize;

const Account = require('../models').Account;
const Guard = require('./guard');

module.exports.findByEmail = async function(email) {
  return await Account.findOne({
    where: { email: email }
  });
};

const create = function(accountData, transaction) {
  const credentials = Guard.generateCredentials(accountData.password);
  return Account.create(
    {
      type: accountData.type,
      name: accountData.name,
      email: accountData.email,
      encryptedPassword: credentials.encryptedPassword,
      salt: credentials.salt,
      lastInteractionDate: Date.now(),
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(userData) {
  return sequelize.transaction(t => create(userData, t));
};

module.exports.create = create;
