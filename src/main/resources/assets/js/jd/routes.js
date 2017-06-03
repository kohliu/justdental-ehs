/*
Routes and page re-direction will declared there.
*/

function doNothing()
{

}

function loadDoctorLandingPage() {    
    return replaceBodyContent('/html/doctor/doctorlanding.html', initDoctorLandingPage);
}

function loadAdminLandingPage() {    
    return replaceBodyContent('/html/admin/adminlanding.html', initAdminLandingPage);
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