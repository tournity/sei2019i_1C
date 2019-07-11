'use strict';
const StageDefnition = require('../table_definitions').StageDefnition;

module.exports = (sequelize, DataTypes) => {
  const Stage = sequelize.define('Stage', StageDefnition.build(DataTypes), {});
  Stage.associate = function(models) {
    // associations can be defined here
  };
  return Stage;
};
