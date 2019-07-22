'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    stageGroup: {
      allowNull: false,
      unique: 'stageGroup, userSportGroupCompetitor',
      references: {
        model: 'StageGroups',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    userSportGroupCompetitor: {
      allowNull: false,
      unique: 'stageGroup, userSportGroupCompetitor',
      references: {
        model: 'UserSportGroupCompetitors',
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
