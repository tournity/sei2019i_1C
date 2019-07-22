'use strict';
const UserDefnition = require('../table_definitions').UserSportDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSport = sequelize.define(
    'UserSport',
    UserDefnition.build(DataTypes),
    {}
  );
  UserSport.associate = function(models) {
    // associations can be defined here
  };
  return UserSport;
};
