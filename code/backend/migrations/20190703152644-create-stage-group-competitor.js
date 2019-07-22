'use strict';
const StageGroupCompetitorDefnition = require('../table_definitions')
  .StageGroupCompetitorDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'StageGroupCompetitors',
      StageGroupCompetitorDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('StageGroupCompetitors');
  }
};
