'use strict';
const TournamentDefnition = require('../table_definitions').TournamentDefnition;

module.exports = (sequelize, DataTypes) => {
  const Tournament = sequelize.define(
    'Tournament',
    TournamentDefnition.build(DataTypes),
    {}
  );
  Tournament.associate = function(models) {
    // associations can be defined here
  };
  return Tournament;
};
