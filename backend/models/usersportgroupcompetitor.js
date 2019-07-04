'use strict';
module.exports = (sequelize, DataTypes) => {
  const UserSportGroupCompetitor = sequelize.define(
    'UserSportGroupCompetitor',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  UserSportGroupCompetitor.associate = function(models) {
    // associations can be defined here
  };
  return UserSportGroupCompetitor;
};
