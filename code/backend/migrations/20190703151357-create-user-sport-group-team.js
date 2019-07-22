'use strict';
const UserSportGroupTeamDefnition = require('../table_definitions')
  .UserSportGroupTeamDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSportGroupTeams',
      UserSportGroupTeamDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSportGroupTeams');
  }
};
