const sequelize = require('../../models').sequelize;

const Sport = require('../../models').Sport;

const SuperAdmin = require('../../models').SuperAdmin;

const User = require('../../models').User;

module.exports.create = function(sportData) {
    return Sport.create(
      {
        name: sportData.name,
        description: sportData.description,
        createdBy: 1,
        status: 'active'

    }
    );

  };
