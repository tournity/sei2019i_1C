const SportRepository = require('../repositories').SportRepository;

module.exports.register = (req, res) => {
  if (req.body.name) {
    SportRepository.create(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'sport succesful created'
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
