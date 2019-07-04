'use strict';
module.exports = (sequelize, DataTypes) => {
  const User = sequelize.define(
    'User',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  User.associate = function(models) {
    // associations can be defined here
  };
  return User;
};
