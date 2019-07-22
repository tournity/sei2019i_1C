const UserSportGroupRepository = require('../repositories').UserSportGroupRepository;

module.exports.register = (req, res) => {
  if (req.body.name && req.body.description) {
    UserSportGroupRepository.create(req.body)
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

module.exports.groupList = (req, res, id) => {
  UserSportRepository.groupList(id, req.decoded.id).then(() => {
    res.json({
      success: true,
      message: 'user succesful created'
    });
  })
  .catch(error => res.status(500).json({ message: error.message }));
} 
