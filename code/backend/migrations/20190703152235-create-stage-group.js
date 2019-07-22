'use strict';
const StageGroupDefnition = require('../table_definitions').StageGroupDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'StageGroups',
      StageGroupDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('StageGroups');
  }
};
