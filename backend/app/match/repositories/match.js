const sequelize = require('../../models').sequelize;

const Match = require('../../models').Match;

const create = function(matchData, transaction) {
  return Match.create(
    {
      name: matchData.name,
      description: matchData.description,
      startDate : matchData.startDate,
      endDate : matchData.endDate,
      stageGroup : matchData.stageGroup,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(matchData) {
  return sequelize.transaction(t => create(matchData, t));
};

module.exports.create = create;
