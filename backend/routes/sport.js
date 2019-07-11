const SportController = require('../controllers').SportController;

var router = require('express').Router();

router.post('/', SportController.register);

module.exports = router;