const GuardRouter = require('./guard');
const AccountRouter = require('./account');
const CompetitorRouter = require('./competitor')
const TeamRouter = require('./team');
const UserSportGroupRouter = require('./user-sport-group');
const SportRouter = require('./sport');
const UserSportRouter = require('./user-sport');

module.exports = {
  GuardRouter,
  AccountRouter,
  CompetitorRouter,
  TeamRouter,
  UserSportGroupRouter,
  SportRouter,
  UserSportRouter
};
