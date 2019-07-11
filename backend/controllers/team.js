const TeamRepository = require('../repositories').TeamRepository;

module.exports.register = (req, res) => {
  if (true) {
    TeamRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'team succesful created'
        });
      })
      .catch(error => res.status(500).json({ message: error.message }));
  } else {
    res.status(400).json({
      success: false,
      message: 'wrong Parameters'
    });
  }
};
