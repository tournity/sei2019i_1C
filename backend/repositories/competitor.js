const sequelize = require('../models').sequelize;

const Competitor = require('../models').UserSportGroupCompetitor;
const Guard = require('./guard');

const create = function(competitorData, transaction) {
  return Competitor.create(
    {
      type: competitorData.type,
      name: competitorData.name,
      description: competitorData.description,
      userSportGroup : competitorData.userSportGroup,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(competitorData) {
  return sequelize.transaction(t => create(competitorData, t));
};

module.exports.create = create;
