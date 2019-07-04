'use strict';
const UserSportGroupPlayerDefnition = require('../table_definitions')
  .UserSportGroupPlayerDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSportGroupPlayers',
      UserSportGroupPlayerDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSportGroupPlayers');
  }
};
