'use strict';
module.exports = (sequelize, DataTypes) => {
  const StageGroup = sequelize.define(
    'StageGroup',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  StageGroup.associate = function(models) {
    // associations can be defined here
  };
  return StageGroup;
};
