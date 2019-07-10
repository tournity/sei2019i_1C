'use strict';
const UserDefnition = require('../table_definitions').UserDefnition;

module.exports = (sequelize, DataTypes) => {
  const User = sequelize.define('User', UserDefnition.build(DataTypes), {});
  User.associate = function(models) {
    // associations can be defined here
  };
  return User;
};
