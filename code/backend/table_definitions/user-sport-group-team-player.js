'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    description: {
      type: DataTypes.STRING
    },
    userSportGroupPlayer: {
      allowNull: false,
      unique: true,
      references: {
        model: 'UserSportGroupPlayers',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    userSportGroupTeam: {
      allowNull: false,
      references: {
        model: 'UserSportGroupTeams',
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
