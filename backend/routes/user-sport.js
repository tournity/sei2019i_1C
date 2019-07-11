const UserSportController = require('../controllers').UserSportController;

var router = require('express').Router();

router.post('/', UserSportController.register);

module.exports = router;