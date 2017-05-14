function ValidateEmail(mail) {
    var isValidEmail = false;
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
        isValidEmail = true;
    }
    console.log(isValidEmail, mail);
    return isValidEmail;
}

function validatePhonenumber(phonenumber) {
    var isValidNumber = false;
    var phoneno = /^\d{10}$/;
    if (phoneno.test(phonenumber)) {
        isValidNumber = true;
    }
    return isValidNumber;
}
$(document).ready(function () {
    $('.forgot-pass').click(function (event) {
        $(".pr-wrap").toggleClass("show-pass-reset");
    });
    $('.pass-reset-submit').click(function (event) {
        $(".pr-wrap").removeClass("show-pass-reset");
    });
    //$.getScript("messageUtil.js");
});
$(function () {
    /*
        Highcharts.chart('container', {
            title: {
                text: 'Clinical Data - By Numbers 2017'
                , x: -20 //center
            }
            , subtitle: {
                text: ''
                , x: -20
            }
            , xAxis: {
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'
                    , 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            }
            , yAxis: {
                title: {
                    text: 'People'
                }
                , plotLines: [{
                    value: 0
                    , width: 1
                    , color: '#808080'
                }]
            }
            , tooltip: {
                formatter: function () {
                    return 'There are <b>' + this.y + '</b> '+this.series.name + ' registered in <b>'+ this.x + '</b>';
                }
            }
            , legend: {
                layout: 'vertical'
                , align: 'right'
                , verticalAlign: 'middle'
                , borderWidth: 0
            }
            , series: [{
                name: 'New Patients'
                , data: [7, 6, 9, 14, 29, 49, 82, 126, 55, 70, 88, 102]
            }, {
                name: 'Total Patients'
                , data: [1, 22, 35, 48, 73, 91, 125, 166, 184, 200, 220, 250]
            }, {
                name: 'Corporate Patients'
                , data: [1, 6, 29, 8, 48, 2, 35, 55, 53, 78, 90, 90]
            }]
        });


        
        Highcharts.chart('appointmentChart', {
            chart: {
                type: 'pie',
                options3d: {
                    enabled: true,
                    alpha: 45
                }
            },
            title: {
                text: 'Appointments'
            },        
            plotOptions: {
                pie: {
                    innerSize: 100,
                    depth: 45
                }
            },
            series: [{
                name: 'appointments',
                data: [
                    ['Consulted', 90],
                    ['Cancelled', 10]
                ]
            }]
        });
        
        Highcharts.chart('patientChart', {
            chart: {
                type: 'pie',
                options3d: {
                    enabled: true,
                    alpha: 45
                }
            },
            title: {
                text: 'Patient details'
            },        
            plotOptions: {
                pie: {
                    innerSize: 100,
                    depth: 45
                }
            },
            series: [{
                name: 'patient(s)',
                data: [
                    ['New', 90],
                    ['Already registered', 10]
                ]
            }]
        });
        
        
       
        
        Highcharts.chart('doctorChart', {
            chart: {
                type: 'pie',
                options3d: {
                    enabled: true,
                    alpha: 45
                }
            },
            title: {
                text: 'Specialization'
            },        
            plotOptions: {
                pie: {
                    innerSize: 100,
                    depth: 45
                }
            },
            series: [{
                name: 'specialist',
                data: [
                    ['Dentist', 35],
                    ['Prosthodontist', 20],
                    ['Orthodontist', 10],
                    ['Endodontist', 20],
                    ['Implantologist', 10]
                ]
            }]
        });
        */
    //console.log(JSON.stringify($('#calendar')));
    /* if($('#calendar'))
     {
         $('#calendar').fullCalendar({
             // put your options and callbacks here
         })
     }*/
});

$(document).ready(function() {

    // page is now ready, initialize the calendar...
    if($('#calendar'))
    {
        $('#calendar').fullCalendar({
            // put your options and callbacks here
        })
    }

});
function bookAppointmentFromHomepage() {
    var payload = getBookAppointment4HomepagePayload();
    var firstName = document.getElementById('home.appmnt.firstName').value;
    var lastName = document.getElementById('home.appmnt.lastName').value;
    var phonenumber = document.getElementById('home.appmnt.phonenumber').value;
    var emailId = document.getElementById('home.appmnt.emailid').value;
    // var dob = document.getElementById('home.appmnt.dob').value;
    var message = document.getElementById('home.appmnt.message').value;
    payload.appointmentDescription = message;
    payload.creationDate = new Date();
    payload.appointmentTakenBy = firstName + '  ' + lastName;
    console.log(BOOK_APPNT_HOMEPAGE, JSON.stringify(payload));
    fetch(BOOK_APPNT_HOMEPAGE, {
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
        toastr.success('Thanks, ' + firstName + '  ' + lastName + ' We have received your appointment. Our team will get back to you.');
    }).catch(function (err) {
        toastr.error(JSON.stringify(err));
    });
}

function subscribe() {
    var emailId = document.getElementById('subscribe-emailid').value;
    var payload = {
        emailAddress: emailId
    };
    fetch(SUBSCRIBE, {
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
        toastr.success('Your email id ' + emailId + ' is subcribed with JUST DENTAL.');
    }).catch(function (err) {
        toastr.error(JSON.stringify(err));
    });
}
/* Main screen login */
function login() {
    console.log("Login called  " + NATIVE_LOGIN);
    var loginId = document.getElementById('homepage:login:username').value;
    var password = document.getElementById('homepage:login:password').value;
    var payload = {};
    payload.uniqueUserId = loginId;
    payload.userPassword = password;
    payload.emailAddress = loginId;
    payload.phoneNumber = loginId;
    var errorMessages = [];
    var consolidateErrorMessage = '';
    errorMessages.push('<ui>');
    if (loginId.trim() == '') {
        errorMessages.push('<li>Username / Mobile Number is mandatory.</li>');
    }
    if (password.trim() == '') {
        errorMessages.push('<li>Password is mandatory</li>');
    }
    errorMessages.push('</ui>');
    errorMessages.forEach(function (currentMsg) {
        consolidateErrorMessage += '<br/>' + currentMsg;
    });
    console.log(consolidateErrorMessage);
    if (errorMessages.length > 2) {
        toastr.error(consolidateErrorMessage);
        return;
    }
    else {
        fetch(NATIVE_LOGIN, {
            method: 'POST'
            , mode: 'cors'
            , redirect: 'follow'
            , credentials: 'include'
            , headers: {
                'Accept': 'application/json'
                , 'Content-Type': 'application/json'
            }
            , body: JSON.stringify(payload)
        }).then(function (response, kkk) {
            if (!response.ok) {
                console.log(response.json());
                if (response.status == 401) {
                    toastr.error('Unauthorized, Please check login details.');
                }
                else {
                    throw Error(response)
                }
            }
            else {                 
                response.json().then(function(data) 
                {
                    $('logout').toggle();  
                    console.log(data);
                    loginUserFullName = data.firstName +"   "+data.lastName+"( "+data.userType+" )";
                    displayLoggedinUsername();
                });
                $('#loginModal').modal('hide');
                window.location.href = '/html/misc/multi-profile.html';
            }
            console.log(response);
            return response;
        }).catch(function (error) {
            console.log('Error occured while logging', error);
            toastr.error('Error occured while logging');
        });
    }
}
                
function displayLoggedinUsername()
{
    console.log('displayLoggedinUsername   ', loginUserFullName);
    document.getElementById('userLogin').innerHTML = loginUserFullName;
}
/* Main screen regstration */
function register() {
    //var loginId = document.getElementById('homepage:username').value;
    var password = document.getElementById('homepage:password').value;
    var firstName = document.getElementById('homepage:firstName').value;
    var lastName = document.getElementById('homepage:lastName').value;
    var emailId = document.getElementById('homepage:emailId').value;
    var mobileNumber = document.getElementById('homepage:mobileNumber').value;
    var payload = {};
    //var errorMesages = [];
    //validateMandatoryField();
    console.log(JSON.stringify(payload));
    payload.uniqueUserId = emailId;
    payload.emailAddress = emailId;
    //payload.uniqueUserId = loginId;
    payload.userPassword = password;
    payload.firstName = firstName;
    payload.lastName = lastName;
    payload.phoneNumber = mobileNumber;
    var errorMessages = [];
    var consolidateErrorMessage = '';
    errorMessages.push('<ui>');
    /*if (loginId.trim() == '') {
        errorMessages.push('<li>Username / Mobile Number is mandatory.</li>');
    }*/
    if (password.trim() == '') {
        errorMessages.push('<li>Password is mandatory</li>');
    }
    if (lastName.trim() == '') {
        errorMessages.push('<li>Lastname is mandatory.</li>');
    }
    if (firstName.trim() == '') {
        errorMessages.push('<li>Firstname is mandatory</li>');
    }
    if (emailId.trim() == '') {
        errorMessages.push('<li>email id is mandatory.</li>');
    }
    else if (!ValidateEmail(emailId)) {
        errorMessages.push('<li>Invalid emailId entered.</li>');
    }
    if (mobileNumber.trim() == '') {
        errorMessages.push('<li>Mobilenumber is mandatory</li>');
    }
    else if (!validatePhonenumber(mobileNumber.trim())) {
        errorMessages.push('<li>Mobilenumber is not valid</li>');
    }
    errorMessages.push('</ui>');
    errorMessages.forEach(function (currentMsg) {
        consolidateErrorMessage += '<br/>' + currentMsg;
    });
    console.log(consolidateErrorMessage);
    if (errorMessages.length > 2) {
        toastr.error(consolidateErrorMessage);
        return;
    }
    else {
        fetch(QUICK_REGISTER, {
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
            if (!response.ok) {
                console.log(response);
                throw Error(response)
            }
            return response;
        }).then(function (response) {
            console.log("ok");
            toastr.success('Congrats ' + firstName + ', Welcome to JUST DENTAL family.');
            toastr.success('Please login to view your profile!');
            $('.nav-tabs a[href="#login"]').tab('show');
        }).catch(function (error) {
            console.log(error);
            toastr.error('User already Exists!');
        });
    }
}

function addDoctorFromAdminLanding() {
    console.log('addDoctorFromAdminLanding');
    var firstname = document.getElementById('adminlanding:adddoctor:firstname').value;
    var middlename = document.getElementById('adminlanding:adddoctor:middlename').value;
    var lastname = document.getElementById('adminlanding:adddoctor:lastname').value;
    var emailid = document.getElementById('adminlanding:adddoctor:emailid').value;
    var qualification = document.getElementById('adminlanding:adddoctor:qualification').value;
    var gender = document.getElementById('adminlanding:adddoctor:gender').value;
    var specialization = document.getElementById('adminlanding:adddoctor:specialization').value;
    var phonenumber = document.getElementById('adminlanding:adddoctor:phonenumber').value;
    var licensenumber = document.getElementById('adminlanding:adddoctor:licensenumber').value;
    var payload = {
        'dateCreated': new Date()
        , 'emailAddress': emailid
        , 'firstName': firstname
        , 'lastName': lastname
        , 'middleName': middlename
        , 'phoneNumber': phonenumber
        , 'qualification': qualification
        , 'specialization': specialization
        , 'userType': 'Doctor'
        , 'licenseNumber': licensenumber,
        'gender': gender
    };
    console.log(JSON.stringify(payload));
    var errorMessages = [];
    var consolidateErrorMessage = '';
    errorMessages.push('<ui>');
    if (firstname.trim() == '') {
        errorMessages.push('<li>Firstname is mandatory.</li>');
    }
    if (lastname.trim() == '') {
        errorMessages.push('<li>lastname is mandatory.</li>');
    }
    if (emailid.trim() == '') {
        errorMessages.push('<li>Emailid is mandatory.</li>');
    }
    else if (!ValidateEmail(emailid)) {
        errorMessages.push('<li>Invalid emailId entered.</li>');
    }
    if (qualification.trim() == '') {
        errorMessages.push('<li>Qualification is mandatory.</li>');
    }
    if (gender.trim() == '') {
        errorMessages.push('<li>Gender is mandatory.</li>');
    }
    if (specialization.trim() == '') {
        errorMessages.push('<li>Specialization is mandatory.</li>');
    }
    if (phonenumber.trim() == '') {
        errorMessages.push('<li>Phonenumber is mandatory.</li>');
    }
    else if (!validatePhonenumber(phonenumber.trim())) {
        errorMessages.push('<li>Mobilenumber is not valid</li>');
    }
    
    /*else if (!phonenumber(mobileNumber.trim())) {
        errorMessages.push('<li>Mobilenumber is not valid</li>');
    }*/
    
    if (licensenumber.trim() == '') {
        errorMessages.push('<li>Licensenumber is mandatory.</li>');
    }
    errorMessages.push('</ui>');
    errorMessages.forEach(function (currentMsg) {
        consolidateErrorMessage += '<br/>' + currentMsg;
    });
    console.log(consolidateErrorMessage);
    if (errorMessages.length > 2) {
        toastr.error(consolidateErrorMessage);
        return;
    }
    else {
        fetch(ADD_DOCTOR_ADMIN_LANDING, {
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
            if (!response.ok) {
                console.log(response);
                throw Error(response)
            }
            return response;
        }).then(function (response) {
            console.log("ok", response);
            toastr.success('Congrats ' + firstname + ' ' + lastname + ', Welcome to JUST DENTAL family.');
            $('#addDoctorModal').modal('hide');
        }).catch(function (error) {
            console.log(error);
            toastr.error('Error while registering Doctor ', JSON.stringify(error));
        });
    }
}

function addClinicFromAdminLanding() {
    console.log('addClinicFromAdminLanding');
    var clinicname = document.getElementById('adminlanding:addclinic:clinicname').value;
    var taxnumber = document.getElementById('adminlanding:addclinic:taxnumber').value;
    var primarycontactname = document.getElementById('adminlanding:addclinic:primarycontactname').value;
    var primarycontactnumber = document.getElementById('adminlanding:addclinic:primarycontactnumber').value;
    var workingday = document.getElementById('adminlanding:addclinic:workingday').value;
    var clinictype = document.getElementById('adminlanding:addclinic:clinictype').value;
    var fromhour = document.getElementById('adminlanding:addclinic:fromhour').value;
    var fromminutes = document.getElementById('adminlanding:addclinic:fromminutes').value;
    var fromtimezone = document.getElementById('adminlanding:addclinic:fromtimezone').value;
    var tohour = document.getElementById('adminlanding:addclinic:tohour').value;
    var tominutes = document.getElementById('adminlanding:addclinic:tominutes').value;
    var totimezone = document.getElementById('adminlanding:addclinic:totimezone').value;
    var gmap = document.getElementById('adminlanding:addclinic:gmap').value;
    var notification = document.getElementById('adminlanding:addclinic:notification').value;
    var street1 = document.getElementById('adminlanding:addclinic:street1').value;
    var street2 = document.getElementById('adminlanding:addclinic:street2').value;
    var city = document.getElementById('adminlanding:addclinic:city').value;
    var pincode = document.getElementById('adminlanding:addclinic:pincode').value;
    var state = document.getElementById('adminlanding:addclinic:state').value;
    var workingHours = fromhour + ':' + fromminutes + ' ' + fromtimezone + ' - ' + tohour + ':' + tominutes + ' ' + totimezone;
    var payload = {
        'dateCreated': new Date()
        , 'city': city
        , 'clinicName': clinicname
        , 'clinicType': clinictype
        , 'country': 'India'
        , 'daysAvailable': workingday
        , 'gmap': gmap
        , 'locality': city
        , 'notification': notification
        , 'pincode': pincode
        , 'primaryContactName': primarycontactname
        , 'primaryContactNumber': primarycontactnumber
        , 'state': state
        , 'street1': street1
        , 'street2': street2
        , 'taxNumber': taxnumber
        , "workingHours": workingHours
    };
    console.log(JSON.stringify(payload));
    var errorMessages = [];
    var consolidateErrorMessage = '';
    errorMessages.push('<ui>');
    if (clinicname.trim() == '') {
        errorMessages.push('<li>Clinicname is mandatory.</li>');
    }
    if (taxnumber.trim() == '') {
        errorMessages.push('<li>Taxnumber is mandatory.</li>');
    }
    if (primarycontactname.trim() == '') {
        errorMessages.push('<li>primarycontactname is mandatory.</li>');
    }
    if (primarycontactnumber.trim() == '') {
        errorMessages.push('<li>Primarycontactnumber is mandatory.</li>');
    }
    if (workingday.trim() == '') {
        errorMessages.push('<li>Workingday is mandatory.</li>');
    }
    if (clinictype.trim() == '') {
        errorMessages.push('<li>Clinictype is mandatory.</li>');
    }
    if (gmap.trim() == '') {
        errorMessages.push('<li>Google Map location is mandatory.</li>');
    }
    if (street1.trim() == '') {
        errorMessages.push('<li>Street1 is mandatory.</li>');
    }
    if (street2.trim() == '') {
        errorMessages.push('<li>Street2 is mandatory.</li>');
    }
    if (city.trim() == '') {
        errorMessages.push('<li>City is mandatory.</li>');
    }
    if (pincode.trim() == '') {
        errorMessages.push('<li>Pincode is mandatory.</li>');
    }
    if (state.trim() == '') {
        errorMessages.push('<li>State is mandatory.</li>');
    }
    errorMessages.push('</ui>');
    errorMessages.forEach(function (currentMsg) {
        consolidateErrorMessage += '<br/>' + currentMsg;
    });
    console.log(consolidateErrorMessage);
    if (errorMessages.length > 2) {
        toastr.error(consolidateErrorMessage);
        return;
    }
    else {
        fetch(ADD_CLIINC_ADMIN_LANDING, {
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
            if (!response.ok) {
                console.log(response);
                throw Error(response)
            }
            return response;
        }).then(function (response) {
            console.log("ok", response);
            toastr.success('Congrats ' + clinicname + ' is successfully added, Welcome to JUST DENTAL family.');
            $('#addClinicModal').modal('hide');
            //toastr.success('Please login to view your profile!');
            // $('.nav-tabs a[href="#login"]').tab('show');
        }).catch(function (error) {
            console.log(error);
            toastr.error('Error while adding clinic ', JSON.stringify(error));
        });
    }
}

/** Doctor Landing Page **/

/** init sidebar**/
$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay');
     isClosed = false;
   

    trigger.click(function () {
      hamburger_cross();      
    });
    
    $('[data-toggle="offcanvas"]').click(function () {
        $('#wrapper').toggleClass('toggled');
    });

    function hamburger_cross() {
      if (trigger.attr('class') == 'hamburger is-open') {          
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      }
        else if(trigger.attr('class') == 'hamburger is-closed')
      {   
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }        
  }  
    
    if($("#appointmentChart").length != 0) {       
        Highcharts.chart('appointmentChart', {
                chart: {
                    type: 'pie'
                },
                title: {
                    text: 'Appointment Status',
                     margin: 0
                },        
                plotOptions: {
                    pie: {
                        
                          size:120
                    }
                },
                series: [{
                    name: 'appointments',
                    data: [
                        ['Consulted', 90],
                        ['Cancelled', 10]
                    ]
                }]
            }); 
        
        Highcharts.chart('clinicChart', {
                chart: {
                    type: 'pie'
                },
                title: {
                    text: 'Appointments by Clinic',
                     margin: 0
                },        
                plotOptions: {
                    pie: {
                        
                          size:120
                    }
                },
                series: [{
                    name: 'appointments',
                    data: [
                        ['Vagus', 70],
                        ['Rukmini', 20],
                        ['Aditi', 10]
                    ]
                }]
            }); 
        
        Highcharts.chart('timingChart', {
                chart: {
                    type: 'pie'
                },
                title: {
                    text: 'Appointments by Time',
                     margin: 0
                },        
                plotOptions: {
                    pie: {
                        
                          size:120
                    }
                },
                series: [{
                    name: 'appointments',
                    data: [
                        ['Morning', 10],
                        ['evening', 90]
                    ]
                }]
            }); 
    }
    
});

function toggleDoctorSidebar(pageBookmark){
    var trigger = $('.hamburger'), overlay = $('.overlay');
   
    if(trigger.attr('class') == 'hamburger is-closed')
    {
        overlay.show();
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
    }
    else if(trigger.attr('class') == 'hamburger is-open')
    {
         overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
    }
    $('#wrapper').toggleClass('toggled');
    toggleDoctorMainContent(pageBookmark);
}

function toggleDoctorMainContent(pageBookmark)
{    
     $(doctorPageBookmark).toggle();   
     $(pageBookmark).toggle();
     doctorPageBookmark = pageBookmark;
     loadContentForSelectedContent(pageBookmark);
}

function addPatientFromDoctorLanding()
{
   
      /*

      "dateOfBirth": "2017-05-13T12:20:56.388Z",
      "insuranceExpiration": "2017-05-13T12:20:56.388Z",
      "insuranceNumber": "string",
      "packageId": 0,
      "patientDisplayId": "string",
      "placeOfBirth": "string",
      "religion": "string"
      */
  

    var payload = {};
    payload.insuranceNumber = 99999;
    payload.insuranceExpiration = new Date();
    payload.socialHistory = document.getElementById('doctorlanding:addPatient:socialHistory').value;
    payload.familyHistory = document.getElementById('doctorlanding:addPatient:familyHistory').value;
    payload.medicalHistory = document.getElementById('doctorlanding:addPatient:medicalHistory').value;
    payload.aadharNumber = document.getElementById('doctorlanding:addPatient:aadharNumber').value;
    payload.habbits = document.getElementById('doctorlanding:addPatient:habbits').value;
    payload.patientNote = document.getElementById('doctorlanding:addPatient:patientNote').value;
    payload.occupation = document.getElementById('doctorlanding:addPatient:occupation').value;
    
    payload.emergencyContactNumber = document.getElementById('doctorlanding:addPatient:emergencyContactPhonenumber').value;
    payload.emergencyContactRelationship = document.getElementById('doctorlanding:addPatient:emergencyContactrelationship').value;
    payload.emergencyContactName = document.getElementById('doctorlanding:addPatient:emergencyContactName').value;
    
    payload.state = document.getElementById('doctorlanding:addPatient:state').value;
    payload.pincode = document.getElementById('doctorlanding:addPatient:pincode').value;
    payload.city = document.getElementById('doctorlanding:addPatient:city').value;
    payload.locality = document.getElementById('doctorlanding:addPatient:locality').value;
    payload.street2 = document.getElementById('doctorlanding:addPatient:street2').value;
    payload.street1 = document.getElementById('doctorlanding:addPatient:street1').value;
    payload.country = 'India';
        
    payload.bloodGroup = document.getElementById('doctorlanding:addPatient:bloodgrp').value;
    payload.gender = document.getElementById('doctorlanding:addPatient:gender').value;
    payload.maritalStatus = document.getElementById('doctorlanding:addPatient:status').value;
    payload.phoneNumber = document.getElementById('doctorlanding:addPatient:phoneNumber').value;
    payload.emailAddress = document.getElementById('doctorlanding:addPatient:emailId').value;
    payload.lastName = document.getElementById('doctorlanding:addPatient:lastname').value;
    payload.middleName = document.getElementById('doctorlanding:addPatient:middlename').value;
    payload.firstName = document.getElementById('doctorlanding:addPatient:firstname').value;
    payload.uniqueUserId = document.getElementById('doctorlanding:addPatient:emailId').value;
    console.log(JSON.stringify(payload));
    
    fetch(ADD_PATIENT, {
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
            if (!response.ok) {
                console.log(response);
                throw Error(response)
            }
            return response;
        }).then(function (response) {
            console.log("ok", response);
            toastr.success('New patient added sucessfully');           
        }).catch(function (error) {
            console.log(error);
            toastr.error('Error while adding patient ', JSON.stringify(error));
        });  
}

function updateDoctorFromDoctorLanding()
{
    var firstname= document.getElementById('doctorlanding:updateDoctor:firstname').value ;
    var middlename = document.getElementById('doctorlanding:updateDoctor:middlename').value;
    var lastname= document.getElementById('doctorlanding:updateDoctor:lastname').value;
    var emailid = document.getElementById('doctorlanding:updateDoctor:emailid').value;
    var qualification= document.getElementById('doctorlanding:updateDoctor:qualification').value;
    var gender= document.getElementById('doctorlanding:updateDoctor:gender').value;
    var specialization= document.getElementById('doctorlanding:updateDoctor:specialization').value;
    var phonenumber= document.getElementById('doctorlanding:updateDoctor:phonenumber').value;
    var licensenumber= document.getElementById('doctorlanding:updateDoctor:licensenumber').value;
       
    var payload = {};
    payload.firstName = firstname;
    payload.middleName = middlename;
    payload.lastName = lastname;
    payload.emailAddress = emailid;
    payload.qualification = qualification;
    payload.gender = gender;
    payload.specialization = specialization;
    payload.phoneNumber = phonenumber;
    payload.licenseNumber = licensenumber;
    
    fetch(UPDATE_DOCTOR_BY_ID, {
            method: 'PUT'
            , mode: 'cors'
            , redirect: 'follow'
            , credentials: 'include'
            , headers: {
                'Accept': 'application/json'
                , 'Content-Type': 'application/json'
            }
            , body: JSON.stringify(payload)
        }).then(function (response) {
            if (!response.ok) {
                console.log(response);
                throw Error(response)
            }
            return response;
        }).then(function (response) {
            console.log("ok", response);
            toastr.success('Information updated sucessfully');           
        }).catch(function (error) {
            console.log(error);
            toastr.error('Error while updating doctor ', JSON.stringify(error));
        });    
}

function loadContentForSelectedContent(pageBookmark)
{    
   
    if(pageBookmark == '#editProfile')
    {
        fetch(GET_DOCTOR_BY_ID, {
                method: 'GET'
                , mode: 'cors'
                , redirect: 'follow'
                , credentials: 'include'
                , headers: {
                    'Accept': 'application/json'
                    , 'Content-Type': 'application/json'
                }
            }).then(function (response) {
                if (!response.ok) {
                    console.log(response);
                    throw Error(response)
                }
                else{
                    response.json().then(function(data) 
                    {
                        console.log(JSON.stringify(data));  
                        document.getElementById('doctorlanding:adddoctor:firstname').value = data.firstName;
                        document.getElementById('doctorlanding:adddoctor:middlename').value = data.middleName;
                        document.getElementById('doctorlanding:adddoctor:lastname').value = data.lastName;
                        document.getElementById('doctorlanding:adddoctor:emailid').value = data.emailAddress;
                        document.getElementById('doctorlanding:adddoctor:qualification').value = data.qualification;
                        document.getElementById('doctorlanding:adddoctor:gender').selectedIndex = '2';
                        document.getElementById('doctorlanding:adddoctor:specialization').value = data.specialization;
                        document.getElementById('doctorlanding:adddoctor:phonenumber').value = data.phoneNumber;
                        document.getElementById('doctorlanding:adddoctor:licensenumber').value = data.licenseNumber;

                    });
                }
                return response;
            }).then(function (response) {
                
            }).catch(function (error) {
                console.log(error);
                toastr.error('Error while adding clinic ', JSON.stringify(error));
            });
     }
}

function logout()
{
    $('logout').toggle();   
    loginUserFullName = "Login";
    displayLoggedinUsername();
}
