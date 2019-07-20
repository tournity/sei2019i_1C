const GroupController = require('../controllers').GroupController;
const AuthenticationController = require('../../../app/authentication/controllers')
  .AuthenticationController;

var router = require('express').Router();

router.post(
  '/',
  AuthenticationController.authorize,
  GroupController.register
);

module.exports = router;
