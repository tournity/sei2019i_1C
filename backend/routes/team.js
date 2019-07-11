const TeamController = require('../controllers').TeamController;
const GuardController = require('../controllers').GuardController;

var router = require('express').Router();

router.post('/',GuardController.authorize, TeamController.register);

module.exports = router;
