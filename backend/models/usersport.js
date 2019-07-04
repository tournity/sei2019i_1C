'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSport = sequelize.define(
    'UserSport',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSport.associate = function(models) {
    // associations can be defined here
  };
  return UserSport;
};
