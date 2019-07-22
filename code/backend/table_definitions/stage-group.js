'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    name: {
      allowNull: false,
      unique: 'name, stage',
      type: DataTypes.STRING
    },
    description: {
      type: DataTypes.STRING
    },
    stage: {
      allowNull: false,
      unique: 'name, stage',
      references: {
        model: 'Stages',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    status: {
      allowNull: false,
      validate: {
        notEmpty: true
      },
      type: DataTypes.ENUM('active', 'deleted')
    },
    createdAt: {
      allowNull: false,
      type: DataTypes.DATE
    },
    updatedAt: {
      allowNull: false,
      type: DataTypes.DATE
    }
  };
};
