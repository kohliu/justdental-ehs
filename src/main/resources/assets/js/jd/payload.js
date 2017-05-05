/* payload for screens which defaults fields */
var createLogin = {
 "userIdFk": {
"userId": 2,
   "dateCreated": "2017-03-01T18:29:36.643Z",
   "dateModified": "2017-03-01T18:29:36.643Z",
   "emailAddress": "string",
   "firstName": "string",
   "isActive": 0,
   "lastName": "string",
   "licenseNumber": "string",
   "middleName": "string",
   "modifiedBy": "string",
   "phoneNumber": "string",
   "qualification": "string",
   "roleId": {
     "roleId": 1
   },
   "specialization": "string",
   "userType": "string"
 },
 "uniqueLoginName": "string",
 "dateCreated": "2017-03-01T18:29:36.643Z",
 "dateModified": "2017-03-01T18:29:36.643Z",
 "lastPasswordChanged": "2017-03-01T18:29:36.643Z",
 "modifiedBy": "string",
 "passwordAnswer": "string",
 "passwordKey": "string",
 "passwordQuestion": "string"
};

var login = {
    "userIdFk": {
        "emailAddress": "string"
    }
    , "passwordKey": "string"
    , "uniqueLoginName": "string"
};

var bookAppointment4HomePage =  {
  "appointmentDescription": "string",
  "appointmentStatus": "PENDING_APPROVAL",
  "appointmentTakenBy": "string",
  "appointmentStartTime": "2017-04-02T06:21:56.571Z",
  "creationDate": "2017-04-02T06:21:56.573Z", 
  "appoitmentStartTime": "2017-04-02T06:21:56.574Z"
};

function getBookAppointment4HomepagePayload(){
    return jQuery.extend(true, {}, bookAppointment4HomePage);
}

function getCreateLoginPayload(){
    return jQuery.extend(true, {}, createLogin);
}

function getLoginPayload(){
    return jQuery.extend(true, {}, login);
}

function getCalendarForReceptionist()
{
    
}


function getAllDoctorsAppmntByClinic()
{
    
}

function getAllDoctorsAppmntByStatus()
{
    
}

function getAllDoctorsAppmntByTiming()
{
    
}