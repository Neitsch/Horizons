var express = require('express');
var request = require('request');
var router = express.Router();
  
/* GET home page. */
router.get('/', function(req, res) {
  //request.get('http://104.236.92.157/course/all/', function (error, res, body) {
  //  if (!error && res.statusCode == 200) {
  //    console.log(body);
  //  }    
  //});

  res.render('dashboard', { title: 'Horizons' });
});

module.exports = router;
