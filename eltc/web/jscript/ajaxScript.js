var req;
var isIE;
// for find organizations start///
var inputField;
var completeSelect;
var autoRow;
var numRecords;

function init() {
    completeSelect = document.getElementById("findOrganizationsResult");
    inputField = document.getElementById("findOrganization");
    numRecords = document.getElementById("numberRecordsFound");
    numRecords.style.color = "red";
}

function doCompletion() {

    var url = "asyncSearch?entity=organization&find=" + encodeURI(inputField.value);
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callbackFindOrgs;
    req.send(null);
}

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function callbackFindOrgs() {
    clearSelect();
    if (req.readyState == 4) {
        if (req.status == 200) {
            parseMessagesToSelectInput(req.responseXML);
        }
    }
}

function clearSelect() {
    if (completeSelect.getElementsByTagName("option").length > 0) {
        for (loop = completeSelect.childNodes.length - 1; loop >= 0; loop--) {
            completeSelect.removeChild(completeSelect.childNodes[loop]);
        }
    }
}

function parseMessagesToSelectInput(responseXML) {
    // no matches returned
    if (responseXML == null) {
        showNumberFoundRecords("Найдено " + 0 + " записей");
        return false;
    } else {
        var orgs = responseXML.getElementsByTagName("values")[0];
        //alert(orgs.childNodes.length);
        showNumberFoundRecords("Найдено " + orgs.childNodes.length + " записей");
        if (orgs.childNodes.length > 0) {
            completeSelect.setAttribute("border", "1");
            for (loop = 0; loop < orgs.childNodes.length; loop++) {
                var organization = orgs.childNodes[loop];
                var name = organization.getElementsByTagName("name")[0];
                var rnn = organization.getElementsByTagName("rnn")[0];
                var id = organization.getElementsByTagName("id")[0];
                appendOrganizatiomToSelect(name.childNodes[0].nodeValue,
                        rnn.childNodes[0].nodeValue,
                        id.childNodes[0].nodeValue);
            }
        }
    }
}

function appendOrganizatiomToSelect(name, rnn, id) {
    var optionElement;
    optionElement = document.createElement("option");
    optionElement.setAttribute("value", id);
    optionElement.appendChild(document.createTextNode(rnn + " " + name));
    completeSelect.appendChild(optionElement);
}

function showNumberFoundRecords(recNumbers) {
    if (numRecords.childNodes.length > 0) {
        numRecords.removeChild(numRecords.childNodes[0]);
    }
    numRecords = document.getElementById("numberRecordsFound");
    numRecords.appendChild(document.createTextNode(recNumbers));
}
// for find organizations end///

///// for delete file start //////

var typeOfFile;

function initDeleteFile(type) {
    typeOfFile = type;
}

function deleteFile(entity, id) {
    var url = "deleteFile?entity=" + entity + "&id=" + id + "&type=" + typeOfFile;
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callbackDeleteFile;
    req.send(null);
}

function callbackDeleteFile() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            parseMessagesAboutDelete(req.responseXML);
        }
    }
}

function parseMessagesAboutDelete(responseXML) {
    if (responseXML == null) {
        alert("No XML response!");
        return false;
    } else {
        var isDeleted = responseXML.getElementsByTagName("deleted")[0];
        var tdFileField = document.getElementById(typeOfFile + "FileBox");
        if (isDeleted.textContent == 1) {
            inputPdfElement = document.createElement("input");
            inputPdfElement.setAttribute("maxlength", "40");
            inputPdfElement.setAttribute("id", typeOfFile + "File");
            inputPdfElement.setAttribute("type", "file");
            inputPdfElement.setAttribute("name", typeOfFile + "File");
            tdFileField.innerHTML = "";
            tdFileField.appendChild(inputPdfElement);
        } else {
            alert("Файл отсутствует на диске!");
        }
    }
}

////for delete file end///////

//forTimeTableFilter start//////////////////
function forTimeTableFilter(el) {
    var vendorSelect = document.getElementById("vendor");
    var catSelect = document.getElementById("category");

    var valVendor = vendorSelect.options[vendorSelect.selectedIndex].value;
    if(valVendor == ""){
        return;
    }
    var valCategory = catSelect.options[catSelect.selectedIndex].value;
    
    var url = "asyncSearch?entity=course&find=" + encodeURI(valVendor) + "&category=" + valCategory;
    req = initRequest();
    req.open("GET", url, true);
    req.onreadystatechange = callbackFindCouses;
    req.send(null);
}



function callbackFindCouses() {
    if (req.readyState == 4) {
        if (req.status == 200) {
            parseMessagesToSelectInputCouses(req.responseXML);
        }
    }
}

function parseMessagesToSelectInputCouses(responseXML) {
    // no matches returned
    var courseSelect = document.getElementById("course");
    if (responseXML == null) {
        //showNumberFoundRecords("Найдено " + 0 + " записей");
        return false;
    } else {

        while (courseSelect.options.length > 0) {
            courseSelect.remove(0);
        }
        var courses = responseXML.getElementsByTagName("values")[0];
        if (courses.childNodes.length > 0) {
            for (loop = 0; loop < courses.childNodes.length; loop++) {
                var course = courses.childNodes[loop];
                var nameRu = course.getElementsByTagName("nameRu")[0];
                var codeOwn = course.getElementsByTagName("codeOwn")[0];
                var id = course.getElementsByTagName("id")[0];
                var opt = document.createElement('option');
                opt.innerHTML = codeOwn.childNodes[0].nodeValue + " " + nameRu.childNodes[0].nodeValue;
                opt.value = id.childNodes[0].nodeValue;
                courseSelect.appendChild(opt);

            }
        }
    }
}
//forTimeTableFilter end//////////////////