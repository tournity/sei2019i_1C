'use strict';
const UserStructureDefnition = require('../table_definitions')
  .UserStructureDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserStructure = sequelize.define(
    'UserStructure',
    UserStructureDefnition.build(DataTypes),
    {}
  );
  UserStructure.associate = function(models) {
    // associations can be defined here
  };
  return UserStructure;
};
