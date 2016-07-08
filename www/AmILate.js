var exec = require('cordova/exec');

exports.getNextAppointment = function(arg0, success, error) {
    exec(success, error, "AmILate", "getNextAppointment", [arg0]);
};
