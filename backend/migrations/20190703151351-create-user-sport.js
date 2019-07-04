'use strict';
const UserSportDefnition = require('../table_definitions').UserSportDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSports',
      UserSportDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSports');
  }
};
