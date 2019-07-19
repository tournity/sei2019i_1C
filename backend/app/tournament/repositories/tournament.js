const sequelize = require('../models').sequelize;

const Tournament = require('../models').Tournament;

const create = function(tournamentData, transaction) {
  return Tournament.create(
    {
      type: tournamentData.type,
      name: tournamentData.name,
      description: tournamentData.description,
      userSportGroup: tournamentData.userSportGroup,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(tournamentData) {
  return sequelize.transaction(t => create(tournamentData, t));
};

module.exports.create = create;
