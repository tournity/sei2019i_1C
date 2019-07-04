'use strict';
module.exports = (sequelize, DataTypes) => {
  const SuperAdmin = sequelize.define(
    'SuperAdmin',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  SuperAdmin.associate = function(models) {
    // associations can be defined here
  };
  return SuperAdmin;
};
