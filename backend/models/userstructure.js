'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserStructure = sequelize.define(
    'UserStructure',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserStructure.associate = function(models) {
    // associations can be defined here
  };
  return UserStructure;
};
