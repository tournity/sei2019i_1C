'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSportGroupPlayer = sequelize.define(
    'UserSportGroupPlayer',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSportGroupPlayer.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupPlayer;
};
