'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSportGroup = sequelize.define(
    'UserSportGroup',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSportGroup.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroup;
};
