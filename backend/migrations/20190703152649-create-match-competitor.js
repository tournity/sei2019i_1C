'use strict';
const MatchCompetitorDefnition = require('../table_definitions')
  .MatchCompetitorDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'MatchCompetitors',
      MatchCompetitorDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('MatchCompetitors');
  }
};
