//LAB and Live
var environment = 'LIVE';

if(environment == 'LAB')
{
    HOSTNAME = 'http://ec2-52-66-11-22.ap-south-1.compute.amazonaws.com:8080';
    console.info('Starting in '+environment+'  '+HOSTNAME);
}
else if (environment == 'LIVE')
{
    HOSTNAME = 'http://ec2-52-42-219-206.us-west-2.compute.amazonaws.com:8080';
}

var NATIVE_LOGIN = HOSTNAME + '/api/jdclinic';
var QUICK_REGISTER = HOSTNAME + '/api/jdnativelogin'; 
var SUBSCRIBE = HOSTNAME + '/api/jdsubscribe'; 
var BOOK_APPNT_HOMEPAGE = HOSTNAME + '/api/jdappointment'; 