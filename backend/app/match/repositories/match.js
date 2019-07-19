const sequelize = require('../models').sequelize;

const Match = require('../models').Match;

const create = function(matchData, transaction) {
  return Match.create(
    {
      type: matchData.type,
      name: matchData.name,
      description: matchData.description,
      userSportGroup: matchData.userSportGroup,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(matchData) {
  return sequelize.transaction(t => create(matchData, t));
};

module.exports.create = create;
