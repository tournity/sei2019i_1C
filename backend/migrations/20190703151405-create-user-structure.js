'use strict';
const UserStructureDefnition = require('../table_definitions')
  .UserStructureDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserStructures',
      UserStructureDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserStructures');
  }
};
