const CompetitorRepository = require('../repositories').CompetitorRepository;

module.exports.register = (req, res) => {
  if (true) {
    CompetitorRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'user succesful created'
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
