const CompetitorController = require('../controllers').CompetitorController;
const GuardController = require('../controllers').GuardController;

var router = require('express').Router();

router.post('/',GuardController.authorize, CompetitorController.register);

module.exports = router;
