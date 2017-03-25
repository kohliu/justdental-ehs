//$(function() {
$(document).ready(function() {
	var todayDate = moment().startOf('day');
	var YM = todayDate.format('YYYY-MM');
	var YESTERDAY = todayDate.clone().subtract(1, 'day').format('YYYY-MM-DD');
	var TODAY = todayDate.format('YYYY-MM-DD');
	var TOMORROW = todayDate.clone().add(1, 'day').format('YYYY-MM-DD');
//alert('loading');
	$('#receptionistLanding').fullCalendar({
        eventClick: function(calEvent, jsEvent, view) {
            console.log(calEvent);
           // alert('Edit: ')            
            $('#editEventAppointmentModal').modal('show')
            //debugger;
        },
        select: function(start, end, jsEvent, view) {
            debugger;
        },
        dayClick: function(date, jsEvent, view) {
            //$('#btnClinicEditModal').click();
        //alert('Clicked on: ' + date.format());
            debugger;
//console.log(JSON.stringify(jsEvent));
        //alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
//console.log(JSON.stringify(view));
       // alert('Current view: ' + view.name);

        // change the day's background color just for fun
        $(this).css('background-color', 'red');

    },
        dayNames: ['Sunday', 'Monday', 'Tuesday', 'Wednesday',
 'Thursday', 'Friday', 'Saturday'],
        slotMinutes: 30,
        slotDuration: '00:45:00', 
          defaultEventMinutes: 120,
        firstHour: 8,
        minTime: '08:00:00',
        defaultView: 'agendaWeek',
		header: {
			left: 'prev,next today',
			center: 'title',
			right: 'month,agendaWeek,agendaDay,listWeek'
		},
		editable: true,
		eventLimit: true, // allow "more" link when too many events
		navLinks: true,
        center: 'title',
		events: [
			{
				title: 'Ganesh,Gowtham - Dental Implants',
				start: YM + '-01'
			},
			{
				title: 'Ujjwal Kohli - Root canal',
				start: YM + '-07',
				end: YM + '-08'
			},
			{
				id: 999,
				title: 'Sumant - Genral Checkup',
				start: YM + '-09T16:00:00'
			},
			{
				id: 999,
				title: 'Rama - Crown Fixing',
				start: YM + '-16T16:00:00'
			},
            {
                title: 'Santosh - Crown Fixing',
                start: YM + '-16T10:00:00'
            },
            {
                title: 'RAM (INFOSYS) (C) - Crown Fixing',
                start: YM + '-16T12:00:00'
            },
			{
				title: 'Ujjwal (Series)- Teeth Cavity removal',
				start: YESTERDAY,
				end: TOMORROW
			},
			{
				title: 'Ujjwal (Series)- Chipped teeth fixing',
				start: TOMORROW + 'T14:00:00',
				end: TOMORROW + 'T15:00:00',
			},
			{
				title: 'Aashish - Hyperdontia',
				start: TOMORROW + 'T11:00:00',
				end: YM + '-10'
			},
			{
				title: 'Sudhindra - Brace fixing',
				start: YM + '-27',
				end: YM + '-10'
			},
			{
				title: 'Naidu A - Gum issue',
				start: YM + '-28',
				end: YM + '-10'
			},
			{
				title: 'Mrs. Naidu S - Clenching',
				start: YM + '-22',
				end: YM + '-10'
			}
		]
	});




});