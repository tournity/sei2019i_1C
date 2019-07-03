const Account = require('../models').Account;
let sequelize = require('../models').sequelize;
let Guard = require('./guard.repository');

module.exports.findByEmail = async function(email) {
  return await Account.findOne({
    where: { email: email }
  });
};

let create = function(accountData, t) {
  let credentials = Guard.generateCredentials(accountData.password);
  return Account.create(
    {
      email: accountData.email,
      hash: credentials.hash,
      type: accountData.type,
      name: accountData.name,
      salt: credentials.salt,
      lastInteractionDate: Date.now()
    },
    { transaction: t }
  );
};

module.exports.register = function(accountData) {
  if (accountData.type == 'user') {
    return Customer.create(accountData);
  } else if (accountData.type == 'admin') {
    return Shopkeeper.create(accountData);
  } else if (accountData.type == 'super_admin') {
    return RestaurantAdmin.create(accountData);
  } else {
    return sequelize.transaction(t => create(accountData, t));
  }
};

module.exports.create = create;
