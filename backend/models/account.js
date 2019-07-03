'use strict';
module.exports = (sequelize, DataTypes) => {
  const Account = sequelize.define(
    'Account',
    {
      type: DataTypes.ENUM('user', 'admin', 'super_admin'),
      name: DataTypes.STRING,
      email: DataTypes.STRING,
      encryptedPassword: DataTypes.STRING,
      salt: DataTypes.STRING,
      token: DataTypes.STRING(1000),
      lastInteractionDate: DataTypes.DATE
    },
    {}
  );
  Account.associate = function(models) {
    // associations can be defined here
  };
  return Account;
};
