const GuardController = require('../controllers').GuardController;

var router = require('express').Router();

router.post('/login', GuardController.authenticate);
router.post('/login-with-token', GuardController.authenticateWithToken);
router.post('/sign-out', GuardController.authorize, GuardController.disavow);

module.exports = router;
