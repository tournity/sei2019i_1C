const sequelize = require('../models').sequelize;

const Group = require('../models').UserSportGroup;

const create = function(groupData, transaction) {
  return Group.create(
    {
      type: groupData.type,
      name: groupData.name,
      description: groupData.description,
      userSportGroup: groupData.userSportGroup,
      status: 'active'
    },
    { transaction: transaction }
  );
};

module.exports.register = function(groupData) {
  return sequelize.transaction(t => create(groupData, t));
};

module.exports.create = create;
