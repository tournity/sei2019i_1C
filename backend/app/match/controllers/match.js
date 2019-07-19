const MatchRepository = require('../repositories').MatchRepository;

module.exports.register = (req, res) => {
  if (true) {
    MatchRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'match succesful created'
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
