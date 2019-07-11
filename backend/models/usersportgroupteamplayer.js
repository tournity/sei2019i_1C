'use strict';
const UserSportGroupTeamPlayerDefnition = require('../table_definitions')
  .UserSportGroupTeamPlayerDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSportGroupTeamPlayer = sequelize.define(
    'UserSportGroupTeamPlayer',
    UserSportGroupTeamPlayerDefnition.build(DataTypes),
    {}
  );
  UserSportGroupTeamPlayer.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupTeamPlayer;
};
