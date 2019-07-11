'use strict';
const SuperAdminDefnition = require('../table_definitions').SuperAdminDefnition;

module.exports = (sequelize, DataTypes) => {
  const SuperAdmin = sequelize.define(
    'SuperAdmin',
    SuperAdminDefnition.build(DataTypes),
    {}
  );
  SuperAdmin.associate = function(models) {
    // associations can be defined here
  };
  return SuperAdmin;
};
