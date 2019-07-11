const UserSportRepository = require('../repositories').UserSportRepository;

module.exports.register = (req, res) => {
  
    UserSportRepository.create()
      .then(() => {
        res.json({
          success: true,
          message: 'user succesful created'
        });
      })
      .catch(error => res.status(500).json({ message: error.message }));
  
};