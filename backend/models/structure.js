'use strict';
module.exports = (sequelize, DataTypes) => {
  const Structure = sequelize.define(
    'Structure',
    {
      status: DataTypes.ENUM('active', 'deleted')
    },
    {}
  );
  Structure.associate = function(models) {
    // associations can be defined here
  };
  return Structure;
};
