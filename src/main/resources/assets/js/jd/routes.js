/*
Routes and page re-direction will declared there.
*/

function doNothing()
{

}

function loadClinicPage() {    
    return replaceBodyContent('/html/doctor/doctorlanding.html', doNothing);
}

function loadTeamPage() {    
    return replaceBodyContent('/html/doctor/doctorlanding.html', doNothing);
}

function loadDoctorLandingPage() {    
    return replaceBodyContent('/html/doctor/doctorlanding.html', initDoctorLandingPage);
}

function loadrLandingPage() {    
    return replaceBodyContent('/html/doctor/doctorlanding.html', initDoctorLandingPage);
}

function loadAdminLandingPage() {    
    console.log('jdUserId   ',jdUserId);
    return replaceBodyContent('/html/admin/adminlanding.html', initAdminLandingPage);
}

function loadReceptionistLandingPage() {    
    return replaceBodyContent('html/receptionist/receptionistlanding.html', initDoctorLandingPage);
}

function loadMultiProfilePage() {
    function hideLoginModal()
    {
        $('#loginModal').modal('hide');
    }    
    return replaceBodyContent('/html/misc/multi-profile.html', hideLoginModal);
}

function loadIndexPage()
{
    return replaceBodyContent('index-main.html', doNothing);
}

function replaceBodyContent(pageURI, funcRef)
{
    console.log('replaceBodyContent  ',pageURI, funcRef);
    $("#bodyContent").load(pageURI, function () {
        funcRef();
         return false;
    });
    return false;
}