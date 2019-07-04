'use strict';
module.exports = (sequelize, DataTypes) => {
  const Stage = sequelize.define(
    'Stage',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  Stage.associate = function(models) {
    // associations can be defined here
  };
  return Stage;
};
