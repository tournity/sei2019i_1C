'use strict';
module.exports = (sequelize, DataTypes) => {
  const Tournament = sequelize.define(
    'Tournament',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  Tournament.associate = function(models) {
    // associations can be defined here
  };
  return Tournament;
};
