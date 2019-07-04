var express = require('express');
var cors = require('cors');

var AccountRouter = require('./routes').AccountRouter;
var GuardRouter = require('./routes').GuardRouter;

var app = express();

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.use('/api/account', AccountRouter);
app.use('/api/guard', GuardRouter);

module.exports = app;
