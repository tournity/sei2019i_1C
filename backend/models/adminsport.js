'use strict';
module.exports = (sequelize, DataTypes) => {
  const AdminSport = sequelize.define(
    'AdminSport',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  AdminSport.associate = function(models) {
    // associations can be defined here
  };
  return AdminSport;
};
