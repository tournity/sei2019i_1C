'use strict';
const SportDefnition = require('../table_definitions').SportDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'Sports',
      SportDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('Sports');
  }
};
