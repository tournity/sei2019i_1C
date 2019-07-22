'use strict';
const UserSportGroupPlayerDefnition = require('../table_definitions')
  .UserSportGroupPlayerDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSportGroupPlayer = sequelize.define(
    'UserSportGroupPlayer',
    UserSportGroupPlayerDefnition.build(DataTypes),
    {}
  );
  UserSportGroupPlayer.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupPlayer;
};
