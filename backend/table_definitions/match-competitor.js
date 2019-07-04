'use strict';
module.exports.build = DataTypes => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: DataTypes.INTEGER
    },
    points: {
      allowNull: false,
      type: DataTypes.DECIMAL
    },
    match: {
      allowNull: false,
      unique: 'match, stageGroupCompetitor',
      references: {
        model: 'Matches',
        key: 'id'
      },
      type: DataTypes.INTEGER
    },
    stageGroupCompetitor: {
      allowNull: false,
      unique: 'match, stageGroupCompetitor',
      references: {
        model: 'StageGroupCompetitors',
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
