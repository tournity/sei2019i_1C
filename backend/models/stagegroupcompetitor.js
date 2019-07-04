'use strict';
module.exports = (sequelize, DataTypes) => {
  const StageGroupCompetitor = sequelize.define(
    'StageGroupCompetitor',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  StageGroupCompetitor.associate = function(models) {
    // associations can be defined here
  };
  return StageGroupCompetitor;
};
