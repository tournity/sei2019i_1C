const AccountController = require('../controllers').AccountController;
const GuardController = require('../controllers').GuardController;

var router = require('express').Router();

router.post('/',GuardController.authorize, AccountController.register);

module.exports = router;
