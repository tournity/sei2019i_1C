let AuthenticationRepository = require('../repositories')
  .AuthenticationRepository;

module.exports.authorize = (req, res, next) => {
  AuthenticationRepository.checkToken(req)
    .then(decoded => {
      req.decoded = decoded;
      next();
    })
    .catch(error => res.status(500).json({ message: error.message }));
};

module.exports.authenticateWithToken = (req, res, next) => {
  AuthenticationRepository.checkToken(req)
    .then(accountData => {
      res.json({
        success: true,
        message: 'Authentication successful',
        data: accountData
      });
      req = decoded;
      next();
    })
    .catch(error => res.status(500).json({ message: error.message }));
};

module.exports.authenticate = (req, res) => {
  console.log(req.body);
  AuthenticationRepository.createToken(req.body)
    .then(accountData =>
      res.json({
        success: true,
        message: 'Authentication successful',
        data: accountData
      })
    )
    .catch(error => res.status(500).json({ message: error.message }));
};

module.exports.disavow = (req, res) => {
  AuthenticationRepository.deleteToken(req.decoded)
    .then(() =>
      res.json({
        success: true,
        message: 'Token already disavowed'
      })
    )
    .catch(error => res.status(500).json({ message: error.message }));
};
