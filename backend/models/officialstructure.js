'use strict';
const OfficialStructureDefnition = require('../table_definitions')
  .OfficialStructureDefnition;

module.exports = (sequelize, DataTypes) => {
  const OfficialStructure = sequelize.define(
    'OfficialStructure',
    OfficialStructureDefnition.build(DataTypes),
    {}
  );
  OfficialStructure.associate = function(models) {
    // associations can be defined here
  };
  return OfficialStructure;
};
