// Example using cors:
/*
var cors = require('cors');
var config = require('../config/config.js');
app.get('/products/:id', cors(config.corsOptions), function (req, res, next) {
  res.json({msg: 'This is CORS-enabled for only example.com.'})
});
*/
const AccountRepository = require('../repositories').AccountRepository;

module.exports.register = (req, res) => {
  if (req.body.type && req.body.name && req.body.email && req.body.password) {
    AccountRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'user succesful created'
        });
      })
      .catch(error => res.status(500).json({ message: error.message }));
  } else {
    console.log(req);
    res.status(400).json({
      success: false,
      message: 'wrong Parameters'
    });
  }
};
