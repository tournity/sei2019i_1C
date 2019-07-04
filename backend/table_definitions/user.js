'use strict';
module.exports.build = Sequelize => {
  return {
    id: {
      allowNull: false,
      autoIncrement: true,
      primaryKey: true,
      type: Sequelize.INTEGER
    },
    account: {
      allowNull: false,
      unique: true,
      references: {
        model: 'Accounts',
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
