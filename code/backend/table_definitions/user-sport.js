'use strict';
module.exports.build = Sequelize => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: Sequelize.INTEGER
    },
    owner: {
      allowNull: false,
      unique: 'owner, sport',
      references: {
        model: 'Users',
        key: 'id'
      },
      type: Sequelize.INTEGER
    },
    sport: {
      allowNull: false,
      unique: 'owner, sport',
      references: {
        model: 'Sports',
        key: 'id'
      },
      type: Sequelize.INTEGER
    },
    createdAt: {
      allowNull: false,
      type: Sequelize.DATE
    },
    status: {
      allowNull: false,
      validate: {
        notEmpty: true
      },
      type: Sequelize.ENUM('active', 'deleted')
    },
    updatedAt: {
      allowNull: false,
      type: Sequelize.DATE
    }
  };
};
