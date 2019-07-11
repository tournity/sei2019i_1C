const sequelize = require('../models').sequelize;

const Team = require('../models').UserSportGroupTeam;
const Guard = require('./guard');

const create = function(teamData, transaction) {
  return Team.create(
    {
      userSportGroupCompetitor : teamData.userSportGroupCompetitor,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(teamData) {
  return sequelize.transaction(t => create(teamData, t));
};

module.exports.create = create;
