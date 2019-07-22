'use strict';
const OfficialStructureDefnition = require('../table_definitions')
  .OfficialStructureDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'OfficialStructures',
      OfficialStructureDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('OfficialStructures');
  }
};
