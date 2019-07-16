const CompetitorRouter = require('../authentication/routes/competitor');
const TeamRouter = require('./team');
const UserSportGroupRouter = require('./user-sport-group');
const SportRouter = require('./sport');
const UserSportRouter = require('./user-sport');

module.exports = {
  CompetitorRouter,
  TeamRouter,
  UserSportGroupRouter,
  SportRouter,
  UserSportRouter
};
