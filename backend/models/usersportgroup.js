'use strict';
const UserSportGroupDefnition = require('../table_definitions')
  .UserSportGroupDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSportGroup = sequelize.define(
    'UserSportGroup',
    UserSportGroupDefnition.build(DataTypes),
    {}
  );
  UserSportGroup.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroup;
};
