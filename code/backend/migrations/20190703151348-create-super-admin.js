'use strict';
const SuperAdminDefnition = require('../table_definitions').SuperAdminDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'SuperAdmins',
      SuperAdminDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('SuperAdmins');
  }
};
