'use strict';
const UserSportGroupDefnition = require('../table_definitions')
  .UserSportGroupDefnition;

module.exports = {
  up: (queryInterface, Sequelize) => {
    return queryInterface.createTable(
      'UserSportGroups',
      UserSportGroupDefnition.build(Sequelize)
    );
  },
  down: (queryInterface, Sequelize) => {
    return queryInterface.dropTable('UserSportGroups');
  }
};
