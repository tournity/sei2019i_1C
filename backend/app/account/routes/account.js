const AccountController = require('../controllers').AccountController;
const AuthenticationController = require('../authentication/controllers')
  .AuthenticationController;

var router = require('express').Router();

router.post(
  '/',
  AuthenticationController.authorize,
  AccountController.register
);

module.exports = router;
