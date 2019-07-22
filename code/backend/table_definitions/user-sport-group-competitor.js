'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    type: {
      allowNull: false,
      unique: 'type, name, userSport',
      validate: {
        notEmpty: true
      },
      type: DataTypes.ENUM('players', 'teams')
    },
    name: {
      allowNull: false,
      unique: 'type, name, userSportGroup',
      type: DataTypes.STRING
    },
    description: {
      type: DataTypes.STRING
    },
    userSportGroup: {
      allowNull: false,
      unique: 'type, name, userSportGroup',
      references: {
        model: 'UserSportGroups',
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
