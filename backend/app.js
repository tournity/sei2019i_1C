var express = require('express');
var cors = require('cors');

var AccountRouter = require('./routes').AccountRouter;
var GuardRouter = require('./routes').GuardRouter;
var UserSportGroupRouter = require('./routes').UserSportGroupRouter;
var SportRouter = require('./routes').SportRouter;
var UserSportRouter = require('./routes').UserSportRouter;

var app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/api/accounts', AccountRouter);
app.use('/api/guard', GuardRouter);
app.use('/api/user-sport-groups', UserSportGroupRouter);
app.use('/api/sports', SportRouter);
app.use('/api/user-sports', UserSportRouter);

module.exports = app;
