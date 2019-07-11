'use strict';
const StructureDefnition = require('../table_definitions').StructureDefnition;

module.exports = (sequelize, DataTypes) => {
  const Structure = sequelize.define(
    'Structure',
    StructureDefnition.build(DataTypes),
    {}
  );
  Structure.associate = function(models) {
    // associations can be defined here
  };
  return Structure;
};
