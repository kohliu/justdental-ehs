var MSG_MANDTORY = ' is mandatory';
var MSG_IN_VALID = ' is invalid';

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

function validateMandatoryField(errMessages, fieldValue, name)
{
    if (fieldValue.trim() == '')
    {
        errMessages.push('<li>' + name + MSG_MANDTORY + < /li>');
    }
}
                         
function validateEmailField(errMessages, fieldValue, name)
{
    if (fieldValue.trim() == '')
    {
        errMessages.push('<li>' + name + MSG_MANDTORY + < /li>');
    }
    else if (!validateEmail(fieldValue))
    {
        errMessages.push('<li>' + name + MSG_IN_VALID + < /li>');    
    }
}
