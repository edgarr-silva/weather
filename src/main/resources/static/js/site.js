function setPicker(){

    $( "#search" ).click(function() {
        reloadPageForDateSelection();
    });

    $( "#date1" ).datepicker(
    { dateFormat: 'yy-mm-dd'
    });
    $( "#date2" ).datepicker(
    { dateFormat: 'yy-mm-dd'
    });
};

function getRequestParam(p){
    return (window.location.search.match(new RegExp('[?&]' + p + '=([^&]+)')) || [, null])[1];
};

function setInitialDate(){
    var requestDate1 = getRequestParam('date1');
    var requestDate2 = getRequestParam('date2');
    if(requestDate1 == null || requestDate2 == null){
        requestDate1 = new Date();
        requestDate2 = new Date();
    }else{
        requestDate1 = formatDate(requestDate1);
        requestDate2 = formatDate(requestDate2);
    }
    $('#date1').datepicker('setDate', requestDate1);
    $('#date2').datepicker('setDate', requestDate2);

};

function reloadPageForDateSelection(){
    var selectedDate1 = document.getElementById('date1').value;
    var selectedDate2 = document.getElementById('date2').value;

    if(!validateDate(selectedDate1,selectedDate2)){
        return;
    }
    var redirectLink = window.location.protocol + "//" + window.location.host + window.location.pathname
    + '?date1=' + selectedDate1+ '&date2='+selectedDate2;
    console.log('Redirecting to: ' + redirectLink);
    window.location.href = redirectLink;
};

function formatDate(input) {
    var dateFormat = 'yyyy-mm-dd';
    var parts = input.match(/(\d+)/g),
        i = 0, fmt = {};
    dateFormat.replace(/(yyyy|dd|mm)/g, function(part) { fmt[part] = i++; });

    return new Date(parts[fmt['yyyy']], parts[fmt['mm']]-1, parts[fmt['dd']]);
};


function validateDate(date1,date2){

    var startDate = new Date(date1);
    var endDate = new Date(date2);

    if(startDate.getTime() > endDate.getTime()){
        $('.alert').show();
        return false;
    }
    return true;
}

$(document).ready(function(){
    setPicker();
    setInitialDate();
});