'use strict';
const StageDefnition = require('../table_definitions').StageDefnition;
module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'Stages',
      StageDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('Stages');
  }
};
