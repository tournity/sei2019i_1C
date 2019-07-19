const GroupRepository = require('../repositories').GroupRepository;

module.exports.register = (req, res) => {
  if (true) {
    GroupRepository.register(req.body)
      .then(() => {
        res.json({
          success: true,
          message: 'group succesful created'
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
