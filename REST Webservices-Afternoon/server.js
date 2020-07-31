var express = require('express');
var app = express();
const bodyParser = require('body-parser');
var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://localhost:27017/";
app.use(express.urlencoded());
app.use(express.json());     

app.get('/getTasks', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("rest-assignment");
        var username = req.query.username;
        dbo.collection("tasks").find().toArray(function(err, result) {
          if (err) throw err;
          console.log(result);
          db.close();
          res.send( JSON.stringify(result)); 
        });
      });  
       
})



app.post('/addTask', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("rest-assignment");
        var task = req.body.task;
        var myobj = { task: task };
        
        dbo.collection("tasks").find().toArray(function(err, result) {
            if (err) throw err;
            index=result.length;
            dbo.collection("tasks").insertOne({index:index.toString(),task:task}, function(err2, result2) {
                if (err2) throw err2;
                console.log("new task added");
               db.close('task inserted'); 
                res.send('inserted');
            });
        
        });
        
    });     
})

app.delete('/deleteTask', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("rest-assignment");
        var index = req.body.index;
        console.log(index)
        var myquery = { index: index.toString() };
        dbo.collection("tasks").deleteOne(myquery, function(err, obj) {
          if (err) throw err;
          console.log("task deleted");
          db.close();
          res.end('deleted'); 
        });
        

        
    
    });     
})



app.put('/editTask', function (req, res) {
    MongoClient.connect(url, function(err, db) {
        if (err) throw err;
        var dbo = db.db("rest-assignment");
        var index = req.body.index;
        var task = req.body.task;
        console.log(index)
        var myquery = { index: index.toString() };
        var newvalues = { $set: {task: task} };
        dbo.collection("tasks").updateOne(myquery,newvalues ,function(err, obj) {
          if (err) throw err;
          console.log("task update");
          db.close();
          res.end('update'); 
        });
        

        
    
    });     
})



var server = app.listen(8081, function () {
   var host = server.address().address
   var port = server.address().port
   console.log("To Do app listening at port %s", port)
})