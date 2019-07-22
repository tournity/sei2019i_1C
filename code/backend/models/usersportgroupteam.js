'use strict';
const UserSportGroupTeamDefnition = require('../table_definitions')
  .UserSportGroupTeamDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSportGroupTeam = sequelize.define(
    'UserSportGroupTeam',
    UserSportGroupTeamDefnition.build(DataTypes),
    {}
  );
  UserSportGroupTeam.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupTeam;
};
