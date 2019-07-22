const sequelize = require('../models').sequelize;

const UserSportGroup = require('../models').UserSportGroup;
const UserSportR = require('./user-sport');



module.exports.create = function(usersportgroupData) {
    return UserSportGroup.create(
      {
        name: usersportgroupData.name,
        description: usersportgroupData.description,
        userSport: 2,
        status: 'active',
      }
    );
  };
  
  module.exports.getAllByUserId = function(id, idOwner){
    const userSportData = UserSportR.read(id);
    return UserSportGroup.findAll({where: { 
        userSport: userSportData.id && userSportData.Owner === idOwner,
    } });
  }


