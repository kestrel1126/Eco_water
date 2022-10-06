const mysql = require('./mysql')();

const connection = mysql.init();

mysql.db_open(connection);

connection.query('SELECT * FROM  water_dam',
    function (error, results, fields){
        if (error){
            console.log(error);
        }
        console.log(results);
    });
