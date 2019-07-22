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
      unique: 'name, owner',
      type: Sequelize.STRING
    },
    structure: {
      allowNull: false,
      unique: true,
      references: {
        model: 'Structures',
        key: 'id'
      },
      type: Sequelize.INTEGER
    },
    owner: {
      allowNull: false,
      unique: 'name, owner',
      references: {
        model: 'Users',
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
