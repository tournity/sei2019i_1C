'use strict';
const UserSportGroupCompetitorDefnition = require('../table_definitions')
  .UserSportGroupCompetitorDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSportGroupCompetitors',
      UserSportGroupCompetitorDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSportGroupCompetitors');
  }
};
