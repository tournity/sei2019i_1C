'use strict';
const AdminDefnition = require('../table_definitions').AdminDefnition;

module.exports = (sequelize, DataTypes) => {
  const Admin = sequelize.define('Admin', AdminDefnition.build(DataTypes), {});
  Admin.associate = function(models) {
    // associations can be defined here
  };
  return Admin;
};
