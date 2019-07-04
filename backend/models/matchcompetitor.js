'use strict';
const MatchCompetitorDefnition = require('../table_definitions')
  .MatchCompetitorDefnition;

module.exports = (sequelize, DataTypes) => {
  const MatchCompetitor = sequelize.define(
    'MatchCompetitor',
    MatchCompetitorDefnition.build(DataTypes),
    {}
  );
  MatchCompetitor.associate = function(models) {
    // associations can be defined here
  };
  return MatchCompetitor;
};
