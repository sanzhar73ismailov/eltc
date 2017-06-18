

function checkFileSize(files) {
    // {pdfFile: 15, wordFile: 5}
    var toReturn = true;

    for (var key in files) {
        var input = document.getElementById(key);
        var file = input.files[0];
        var idForMessage = key + 'Big';
        var messageDiv = document.getElementById(idForMessage);
        if (typeof file != 'undefined' && file.size > (files[key] * 1024 * 1024)) {
            toReturn = false;
            if (messageDiv == null) {
                messageDiv = document.createElement("div");
                messageDiv.setAttribute("id", idForMessage);
                messageDiv.appendChild(document.createTextNode("Файл превышает допустимый размер (" + files[key] + " МБ)"));
                messageDiv.style.color = "red";
                input.parentNode.appendChild(messageDiv);
            }
        } else {
            if (messageDiv != null) {
                input.parentNode.removeChild(messageDiv);
            }
        }
    }
    return toReturn;
}



function ChN(xN)	// это целое число без знака ?
{
    var num = "0123456789";
    ret = true;
    for (i = 0; i < xN.length; i++) {
        if (num.indexOf(xN.charAt(i)) < 0) {
            ret = false;
            break;
        }
    }
    return ret;
}
function IsDate(dt) {	// это дата "dd/mm/year" ?
    var ret = false, dd, mm, gg;
    dm = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    if (dt.charAt(2) != '/' || dt.charAt(5) != '/')
        return ret;
    if (dt.length == 10)
    {
        dd = dt.substring(0, 2);	// день
        mm = dt.substring(3, 5);	// месяц
        gg = dt.substring(6, 10);	// год
        if (!ChN(dd) || !ChN(mm) || !ChN(gg))
            return ret;

        if (gg == (100 * Math.floor(gg / 100))) {
            if (gg == (400 * Math.floor(gg / 400)))
                dm[1] = 29;
        } else {
            if (gg == (4 * Math.floor(gg / 4)))
                dm[1] = 29;
        }
        if (0 < mm && mm < 13) {
            if (0 < dd && dd <= dm[mm - 1])
                ret = true;
        }
    }
    return ret;
}
function IsObjDate(obj) {	// Ввели дату "dd/mm/year" или "" ?
    obj.value = Trim(obj.value);
    if (obj.value == '')
        return 1;
    if (!IsDate(obj.value))
    {
        alert('Неверная дата !');
        SetTimeFocus(obj.id);
        return 0;
    } else {
        return 1;
    }
}
// Функция установки фокуса по событию onBlur
function SetTimeFocus(id) {
    setTimeout('document.getElementById("' + id + '").focus()', 200);
}
// вернуть строку без пробелов с краёв
function Trim(str)
{
    str = str.replace(/^\s+/, ''); // Удаляем все пробелы слева
    str = str.replace(/\s+$/, ''); // Удаляем все пробелы справа
    return str;
}
function TempDt(event, obj)
{
    if (event.keyCode == 8)
        return false;
    var v = obj.value, l = v.length;
    if (l == 2)
        obj.value = v + "/";
    if (l == 5)
        obj.value = v + "/";
    return true;
}

function sendFindForm(beanObject) {

    var form = document.getElementById("findFormId");
    // adding page input
    var input = document.createElement('input');
    input.type = 'hidden';
    input.name = 'page';
    input.value = beanObject.page;
    form.appendChild(input);

    document.getElementById('entityFindId').value = beanObject.entity;

    if (beanObject.toFind == null || beanObject.toFind.length == 0) {
        var findInput = document.getElementById("toFindFindId");
        findInput.parentNode.removeChild(findInput);
    } else {
        document.getElementById('toFindFindId').value = beanObject.toFind;
    }


    if (beanObject.entity == 'student') {
        document.getElementById('lastNameRuFindId').value = beanObject.lastNameRu;
        document.getElementById('firstNameRuFindId').value = beanObject.firstNameRu;
        document.getElementById('commentsFindId').value = beanObject.comments;
        document.getElementById('emailFindId').value = beanObject.email;
    }
    else if (beanObject.entity == 'organization') {
        document.getElementById('rnnFindId').value = beanObject.rnn;
        document.getElementById('nameFindId').value = beanObject.name;
    }

    form.submit();
}
function myFunction() {
    alert("Привет!!!");
//document.getElementById("demo").innerHTML="My First JavaScript Function";
}

function confirmDelete() {
    if (confirm("Вы подтверждаете удаление?")) {
        return true;
    } else {
        return false;
    }
}

function setTheSameInSelect(s1, s2) {

    var val1 = document.getElementById(s1).selectedIndex;
    document.getElementById(s2).selectedIndex = val1;
}

function setTheSameInInput(s1, s2) {
    var val1 = document.getElementById(s1).value;
    document.getElementById(s2).value = val1;
}

/*
 
 $.validator.addMethod(
 "russianDate",
 function(value, element) {
 // put your own logic here, this is just a (crappy) example
 return value.match(/^\d\d?[-\.\/\,]\d\d?[-\.\/\,]\d\d\d\d$/) || value.match(/^$/);
 }
 
 );
 
 */
//alert("Hello");
// When the browser is ready...
/*
 $(function() {
 //alert("in script");
 
 // Setup form validation on the #register-form element
 $("#Student").validate({
 // Specify the validation rules
 rules: {
 sex: {
 required: true
 },
 lastNameRu: {
 required: true
 },
 emailOffice: {
 required: true,
 email: true
 },
 firstNameRu: {
 required: true
 },
 patronicNameRu: {
 required: true
 },
 dateOfBirth: {
 russianDate: true
 },
 lastNameEn: {
 required: true
 },
 firstNameEn: {
 required: true
 },
 emailHome: {
 email: true
 },
 emailAdd: {
 email: true
 },
 },
 // Specify the validation error messages
 messages: {
 sex: "Выберите пол",
 lastNameRu: "Введите данные",
 emailOffice: "Введите правильный адрес электронной почты",
 firstNameRu: "Введите данные",
 patronicNameRu: "Введите данные",
 lastNameEn: "Введите данные",
 firstNameEn: "Введите данные",
 emailHome: "Введите правильный адрес электронной почты",
 emailAdd: "Введите правильный адрес электронной почты",
 dateOfBirth: "Введите дату в одном из форматов: дд-мм-гггг, дд.мм.гггг, дд/мм/гггг, дд,мм,гггг"
 
 },
 submitHandler: function(form) {
 form.submit();
 }
 
 
 });
 });
 */

