const sequelize = require('../models').sequelize;

const Group = require('../models').UserSportGroup;

const create = function(groupData, transaction) {
  return Group.create(
    {
      name: groupData.name,
      description: groupData.description,
      userSport: groupData.userSport,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(groupData) {
  return sequelize.transaction(t => create(groupData, t));
};

module.exports.create = create;
