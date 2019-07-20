var express = require('express');
var cors = require('cors');

var AccountRouter = require('./app/account/routes').AccountRouter;
var AuthenticationRouter = require('./app/authentication/routes').AuthenticationRouter;
var CompetitorRouter = require('./app/competitor/routes').CompetitorRouter;
var GroupRouter = require('./app/group/routes').GroupRouter;
var MatchRouter = require('./app/match/routes').MatchRouter;
var SportRouter = require('./app/sport/routes').SportRouter;
var TeamRouter = require('./app/team/routes').TeamRouter;
var TournamentRouter = require('./app/tournament/routes').TournamentRouter;
// var UserRouter = require('./app/user/routes').CompetitorRouter;
// var UserSportGroupRouter = require('./routes').UserSportGroupRouter;
// var UserSportRouter = require('./routes').UserSportRouter;

var app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

// app.use('/api/accounts', AccountRouter);
app.use('/api/auth', AuthenticationRouter);
app.use('/api/competitor', CompetitorRouter);
app.use('/api/group', GroupRouter);
app.use('/api/match', MatchRouter);
app.use('/api/sport', SportRouter);
app.use('/api/team', TeamRouter);
app.use('/api/tournament', TournamentRouter);
// app.use('/api/user', UserRouter);
// app.use('/api/user-sport-groups', UserSportGroupRouter);
// app.use('/api/sports', SportRouter);
// app.use('/api/user-sports', UserSportRouter);

module.exports = app;
