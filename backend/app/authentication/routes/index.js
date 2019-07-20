const AuthenticationRouter = require('./authentication');
// const ActiveAccountRouter = require('./activeAccount');
const CompetitorRouter = require('../../competitor/routes');
const GroupRouter = require('../../group/routes');
const MatchRouter = require('../../match/routes');
const SportRouter = require('../../sport/routes');
const TeamRouter = require('../../team/routes');
const TournamentRouter = require('../../tournament/routes');


module.exports = {
  AuthenticationRouter,
  CompetitorRouter,
  GroupRouter,
  MatchRouter,
  SportRouter,
  TeamRouter,
  TournamentRouter
  // ActiveAccountRouter
};
