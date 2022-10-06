const mysql = require('mysql');

module.exports = function () {
    return {
        init: function () {
            return mysql.createConnection({
                host: 'project-db-stu.ddns.net',
                port: '3307',
                user: 'smai4',
                password: 'smai4',
                database: 'smai4'
            })
        },

        db_open: function (con) {
            con.connect(function (err) {
                if (err) {
                    console.error('mysql 연결 에러남 ㅅㅂ 이유: ' + err);
                } else {
                    console.info('mysql 연결 성공!!!');
                }
            })
        }
    }
};


