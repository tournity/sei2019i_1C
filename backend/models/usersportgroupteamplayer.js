'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSportGroupTeamPlayer = sequelize.define(
    'UserSportGroupTeamPlayer',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSportGroupTeamPlayer.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupTeamPlayer;
};
