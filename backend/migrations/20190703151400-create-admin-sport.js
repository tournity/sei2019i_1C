'use strict';
const AdminSportDefnition = require('../table_definitions').AdminSportDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'AdminSports',
      AdminSportDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('AdminSports');
  }
};
