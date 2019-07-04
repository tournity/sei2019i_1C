'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    startDate: {
      allowNull: false,
      type: DataTypes.DATE
    },
    endDate: {
      allowNull: false,
      type: DataTypes.DATE
    },
    structure: {
      allowNull: false,
      references: {
        model: 'Stages',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    tournament: {
      allowNull: false,
      references: {
        model: 'Tournaments',
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
