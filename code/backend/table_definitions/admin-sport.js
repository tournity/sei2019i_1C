'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    assignedTo: {
      allowNull: false,
      unique: 'assignedTo, sport',
      references: {
        model: 'Admins',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    sport: {
      allowNull: false,
      unique: 'assignedTo, sport',
      references: {
        model: 'Sports',
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
