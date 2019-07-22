const teamRepository = require('../repositories').teamRepository;

module.exports.register = (req, res) => {
  if (req.body.userSportGroupCompetitor) {
    teamRepository.register(req.body)
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
