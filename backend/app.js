var express = require('express');
var cors = require('cors');

var AccountRouter = require('./routes').AccountRouter;
var GuardRouter = require('./routes').GuardRouter;
var CompetitorRouter = require('./routes').CompetitorRouter;
var TeamRouter = require('./routes').TeamRouter;

var app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/api/accounts', AccountRouter);
app.use('/api/guard', GuardRouter);
app.use('/api/competitor', CompetitorRouter);
app.use('/api/team',TeamRouter);

module.exports = app;
