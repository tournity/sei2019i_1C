'use strict';
const AdminSportDefnition = require('../table_definitions').AdminSportDefnition;

module.exports = (sequelize, DataTypes) => {
  const AdminSport = sequelize.define(
    'AdminSport',
    AdminSportDefnition.build(DataTypes),
    {}
  );
  AdminSport.associate = function(models) {
    // associations can be defined here
  };
  return AdminSport;
};
