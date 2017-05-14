//LAB and Live
var environment = 'LAB';

if(environment == 'LOCAL')
{
    HOSTNAME = 'http://localhost:8080';   
}else if(environment == 'LAB')
{
    HOSTNAME = 'http://ec2-52-66-11-22.ap-south-1.compute.amazonaws.com:8080';
   
}else if (environment == 'LIVE')
{
    HOSTNAME = 'http://ec2-52-42-219-206.us-west-2.compute.amazonaws.com:8080';
}
console.info('Starting in '+environment+'  '+HOSTNAME);

var NATIVE_LOGIN = HOSTNAME + '/api/jduser/login';
var GET_DOCTOR_BY_ID = HOSTNAME + '/api/jddoctor/2';
var UPDATE_DOCTOR_BY_ID = HOSTNAME + '/api/jddoctor/2';
var QUICK_REGISTER = HOSTNAME + '/api/jduser';
var SUBSCRIBE = HOSTNAME + '/api/jdsubscribe'; 
var BOOK_APPNT_HOMEPAGE = HOSTNAME + '/api/jdappointment'; 
var ADD_CLIINC_ADMIN_LANDING = HOSTNAME + '/api/jdclinic';
var ADD_DOCTOR_ADMIN_LANDING = HOSTNAME + '/api/jduser';
var ADD_PATIENT = HOSTNAME + '/api/jdpatient';