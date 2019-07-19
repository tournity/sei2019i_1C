const MatchController = require('../controllers').MatchController;
const AuthenticationController = require('../app/authentication/controllers')
  .AuthenticationController;

var router = require('express').Router();

router.post(
  AuthenticationController.authorize,
  MatchController.register
);

module.exports = router;
