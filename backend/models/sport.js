'use strict';
const SportDefnition = require('../table_definitions').SportDefnition;

module.exports = (sequelize, DataTypes) => {
  const Sport = sequelize.define('Sport', SportDefnition.build(DataTypes), {});
  Sport.associate = function(models) {
    // associations can be defined here
  };
  return Sport;
};
