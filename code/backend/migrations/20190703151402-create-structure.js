'use strict';
const StructureDefnition = require('../table_definitions').StructureDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'Structures',
      StructureDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('Structures');
  }
};
