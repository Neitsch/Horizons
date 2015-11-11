var express = require('express');
var request = require('request');
var router = express.Router();
  
//request.get('http://104.236.92.157/course/all/', function (error, res, body) {
//  if (!error && res.statusCode == 200) {
//    console.log(body);
//  }    
//});

/* GET home page. */
router.get('/', function(req, res) {
  res.render('login/index', { title: 'Horizons' });
});

router.post("/logon", function(req, res) {
  //Make post request, and redirect appropriately
  request.post('http://104.236.92.157/authz/login/', {
    json: { 
      username: req.body.username, 
      password: req.body.password 
    }
  }, function(error, resP, body) {
    if (!error && resP.statusCode == 200) {
      res.redirect("/dashboard");
    } else {
      res.redirect("/");
    } 
  });
})

module.exports = router;
