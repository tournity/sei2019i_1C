const UserSportGroupController = require('../controllers').UserSportGroupController;

var router = require('express').Router();

router.post('/', UserSportGroupController.register);

module.exports = router;