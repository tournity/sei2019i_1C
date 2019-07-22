'use strict';
const StageGroupCompetitorDefnition = require('../table_definitions')
  .StageGroupCompetitorDefnition;

module.exports = (sequelize, DataTypes) => {
  const StageGroupCompetitor = sequelize.define(
    'StageGroupCompetitor',
    StageGroupCompetitorDefnition.build(DataTypes),
    {}
  );
  StageGroupCompetitor.associate = function(models) {
    // associations can be defined here
  };
  return StageGroupCompetitor;
};
