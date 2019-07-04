'use strict';
const UserDefnition = require('../table_definitions').UserDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable('Users', UserDefnition.build(Sequelize));
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('Users');
  }
};
