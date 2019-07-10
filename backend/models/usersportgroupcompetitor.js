'use strict';
const UserSportGroupCompetitorDefnition = require('../table_definitions')
  .UserSportGroupCompetitorDefnition;

module.exports = (sequelize, DataTypes) => {
  const UserSportGroupCompetitor = sequelize.define(
    'UserSportGroupCompetitor',
    UserSportGroupCompetitorDefnition.build(DataTypes),
    {}
  );
  UserSportGroupCompetitor.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupCompetitor;
};
