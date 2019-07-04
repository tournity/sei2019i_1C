'use strict';
const MatchDefnition = require('../table_definitions').MatchDefnition;

module.exports = (sequelize, DataTypes) => {
  const Match = sequelize.define('Match', MatchDefnition.build(DataTypes), {});
  Match.associate = function(models) {
    // associations can be defined here
  };
  return Match;
};
