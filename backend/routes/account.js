const AccountController = require('../controllers').AccountController;

var router = require('express').Router();

router.post('/signup', AccountController.register);

module.exports = router;
