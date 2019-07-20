const TournamentController = require('../controllers').TournamentController;
const AuthenticationController = require('../../authentication/controllers')
  .AuthenticationController;

var router = require('express').Router();

router.post(
  '/',
  AuthenticationController.authorize,
  TournamentController.register
);

module.exports = router;
