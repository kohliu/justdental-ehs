function loadDoctorLandingPage()
{   
    $( "#mainBody" ).load( "/html/doctor/doctorlanding.html", function() {
        initDoctorLandingPage();
        return false;
   });
    return false;
}

function loadAdminLandingPage()
{   
    $( "#mainBody" ).load( "/html/admin/adminlanding.html", function() {
        initAdminLandingPage();
        return false;
   });
    return false;
}