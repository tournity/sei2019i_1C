'use strict';
const UserSportGroupTeamPlayerDefnition = require('../table_definitions')
  .UserSportGroupTeamPlayerDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSportGroupTeamPlayers',
      UserSportGroupTeamPlayerDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSportGroupTeamPlayers');
  }
};
