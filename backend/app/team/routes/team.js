const TeamController = require('../controllers').TeamController;
const AuthenticationController = require('../../authentication/controllers')
  .AuthenticationController;

var router = require('express').Router();

router.post('/', AuthenticationController.authorize, TeamController.register);

module.exports = router;
