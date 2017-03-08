/* Main screen login */
function login() {
    console.log("Login called  " + NATIVE_LOGIN);
    /*fetch(NATIVE_LOGIN, {
        method: 'get'
        , mode: 'cors'
        , redirect: 'follow'
        , credentials: 'include'
    }).then(function (response) {
        console.log(response);
    }).catch(function (err) {
        // Error :(
        console.log(err);
    });*/
    var loginUserType = document.getElementById('loginUserType').value;
    console.log(loginUserType);
    if(loginUserType == 'patient'){
        window.location.href = "/html/patient/patientlanding.html";
    } else if (loginUserType == 'receptionist') {
        window.location.href = "/html/receptionist/receptionistlanding.html";
    }
    
}
/* Main screen regstration */
function register() {
    var loginId = document.getElementById('loginId').value;
    
    var password = document.getElementById('password').value;
    var firstName = document.getElementById('firstName').value;
    var lastName = document.getElementById('lastName').value;
    var emailId = document.getElementById('emailId').value;
    var mobileNumber = document.getElementById('mobileNumber').value;
    var payload = getCreateLoginPayload();
    
    console.log(JSON.stringify(payload));
    payload.uniqueLoginName = loginId;
    payload.passwordKey = password;
    payload.userIdFk.firstName = firstName;
    payload.userIdFk.lastName = lastName;
    payload.userIdFk.emailAddress = emailId;
    console.log(JSON.stringify(payload));
    console.log(JSON.stringify(payload));
    fetch(NATIVE_REGISTRATION, {
        method: 'POST'
        , mode: 'cors'
        , redirect: 'follow'
        , credentials: 'include'
        , headers: {
            'Accept': 'application/json'
            , 'Content-Type': 'application/json'
        }
        , body: JSON.stringify(payload)
    }).then(function (response) {
        console.log('suc', response);
    }).catch(function (err) {
        // Error :(
        console.log('err', err);
    });
}