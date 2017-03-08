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

function getCreateLoginPayload(){
    return jQuery.extend(true, {}, createLogin);
}

