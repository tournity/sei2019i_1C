'use strict';
const StageGroupDefnition = require('../table_definitions').StageGroupDefnition;

module.exports = (sequelize, DataTypes) => {
  const StageGroup = sequelize.define(
    'StageGroup',
    StageGroupDefnition.build(DataTypes),
    {}
  );
  StageGroup.associate = function(models) {
    // associations can be defined here
  };
  return StageGroup;
};
