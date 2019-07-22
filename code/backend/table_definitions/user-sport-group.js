'use strict';
module.exports.build = Sequelize => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: Sequelize.INTEGER
    },
    name: {
      allowNull: false,
      unique: 'name, userSport',
      type: Sequelize.STRING
    },
    description: {
      type: Sequelize.STRING
    },
    userSport: {
      allowNull: false,
      unique: 'name, userSport',
      references: {
        model: 'UserSports',
        key: 'id'
      },
      type: Sequelize.INTEGER
    },
    status: {
      allowNull: false,
      validate: {
        notEmpty: true
      },
      type: Sequelize.ENUM('active', 'deleted')
    },
    createdAt: {
      allowNull: false,
      type: Sequelize.DATE
    },
    updatedAt: {
      allowNull: false,
      type: Sequelize.DATE
    }
  };
};
