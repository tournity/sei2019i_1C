'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSportGroupTeam = sequelize.define(
    'UserSportGroupTeam',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSportGroupTeam.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupTeam;
};
