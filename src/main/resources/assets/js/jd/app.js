$(document).ready(function () {
    $('.forgot-pass').click(function (event) {
        $(".pr-wrap").toggleClass("show-pass-reset");
    });
    $('.pass-reset-submit').click(function (event) {
        $(".pr-wrap").removeClass("show-pass-reset");
    });
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
/*
$(document).ready(function() {

    // page is now ready, initialize the calendar...
    if($('#calendar'))
    {
        $('#calendar').fullCalendar({
            // put your options and callbacks here
        })
    }

});*/

function subsrcibe(){
     var emailId = document.getElementById('subscribe-emailid').value;
    var payload = {       
        emailAddress: emailId
    };
   // console.log(SUBSCRIBE, payload, JSON.stringify(payload));
    
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
        toastr.success(emailId+' is subcribed with JUST DENTAL');
    }).catch(function (err) {
        // Error :(
       toastr.error(JSON.stringify(err));
    });
    
   
    
}
