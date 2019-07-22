const sequelize = require('../models').sequelize;

const UserSport = require('../models').UserSport;

module.exports.create = function() {
  return UserSport.create(
    {
      owner: 1,
      sport: 3,
      status: 'active',
    }
  );
};


