const SportController = require('../controllers').SportController;
const AuthenticationController = require('../../authentication/controllers').AuthenticationController;

var router = require('express').Router();

router.post(
   '/' ,
   AuthenticationController.authorize,
   SportController.register);

module.exports = router;
