var express = require('express');
var cors = require('cors');

var AccountRouter = require('./app/authentication/routes').AccountRouter;
var AuthenticationRouter = require('./app/authentication/routes')
  .AuthenticationRouter;
var CompetitorRouter = require('./routes').CompetitorRouter;
var TeamRouter = require('./routes').TeamRouter;
var UserSportGroupRouter = require('./routes').UserSportGroupRouter;
var SportRouter = require('./routes').SportRouter;
var UserSportRouter = require('./routes').UserSportRouter;

var app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/api/accounts', AccountRouter);
app.use('/api/auth', AuthenticationRouter);
app.use('/api/competitor', CompetitorRouter);
app.use('/api/team', TeamRouter);
app.use('/api/user-sport-groups', UserSportGroupRouter);
app.use('/api/sports', SportRouter);
app.use('/api/user-sports', UserSportRouter);

module.exports = app;
