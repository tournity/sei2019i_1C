let sequelize = require('../models').sequelize;

const TeamPlayer = require('../models').usersportgroupteamplayer;

let create = function(PlayerData, transaction) {
  return TeamPlayer.create(
    {
      description: PlayerData.description,
      UserSportGroupTeam: PlayerData.UserSportGroupTeam,
      UserSportGroupPlayer: PlayerData.UserSportGroupPlayer,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(PlayerData) {
    return sequelize.transaction(t => create(PlayerData, t));
};

module.exports.create = create;
