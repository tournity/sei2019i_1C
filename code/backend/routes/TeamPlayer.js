const TeamPlayerController = require('../controllers').TeamPlayerController;

var router = require('express').Router();

router.post('/createTeamPlayer', TeamPlayerController.register);

module.exports = router;
