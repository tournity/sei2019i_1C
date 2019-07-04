'use strict';
const TournamentDefnition = require('../table_definitions').TournamentDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'Tournaments',
      TournamentDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('Tournaments');
  }
};
