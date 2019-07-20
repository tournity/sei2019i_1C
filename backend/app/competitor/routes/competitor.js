const CompetitorController = require('../controllers').CompetitorController;
const AuthenticationController = require('../../authentication/controllers').AuthenticationController;

var router = require('express').Router();

router.post(
  '/',
  AuthenticationController.authorize,
  CompetitorController.register
);

module.exports = router;
