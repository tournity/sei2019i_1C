let sequelize = require('../models').sequelize;

const Account = require('../models').Account;
let Guard = require('./guard');

module.exports.findByEmail = async function(email) {
  return await Account.findOne({
    where: { email: email }
  });
};

let create = function(accountData, transaction) {
  let credentials = Guard.generateCredentials(accountData.password);
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
  if (userData.type == 'type1') {
    return Customer.create(userData);
  } else if (userData.type == 'type2') {
    return Shopkeeper.create(userData);
  } else if (userData.type == 'type3') {
    return RestaurantAdmin.create(userData);
  } else {
    return sequelize.transaction(t => create(userData, t));
  }
};

module.exports.create = create;
