const TournamentRepository = require('../repositories').TournamentRepository;

module.exports.register = (req, res) => {
  if (true) {
    TournamentRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'tournament succesful created'
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
