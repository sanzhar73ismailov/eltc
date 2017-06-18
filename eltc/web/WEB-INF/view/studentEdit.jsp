<%@page pageEncoding="UTF-8" %>
<%!
    public void jspInit() {
    }

    public void jspDestroy() {
    }
%>


<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>


    <%--
    <jsp:useBean id="bean" class="domain.Student" scope="request"/>
    --%>


    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  

    <script>
        function checkStudentform() {
            var maleRadio = document.getElementById("male");
            var femaleRadio = document.getElementById("female");
            if (!maleRadio.checked & !femaleRadio.checked) {
                alert("Необходимо выбрать пол!");
                return false;
            }
            return true;
        }
        function delFunct(thisElement) {
            parentTr = thisElement.parentNode.parentNode;
            previousTr = parentTr.previousSibling;
            previousTr.id = parentTr.id;
            parentTr.remove();
        }
        function selectEmail() {
            var e = document.getElementById("mailSelect");
            var val = e.options[e.selectedIndex].value;
            if (val == "") {
                return;
            }
            var label = e.options[e.selectedIndex].text;
            //alert(val);
            //var divForEmail = document.getElementById("divForEmail");

            //divForEmail.innerHTML += "<tr><td>" + label + "</td><td><input type='text' name='" + val + " value='' size='40' /></td></tr>";
            var lastTr = document.getElementById("last_tr");
            var labelColumn = document.createElement("td");
            var labelElement = document.createElement("label");
            labelElement.setAttribute("for", val);
            labelElement.appendChild(document.createTextNode(label));
            labelColumn.appendChild(labelElement);

            var fieldInput = document.createElement("input");
            fieldInput.setAttribute("type", "email");
            fieldInput.setAttribute("name", val);
            fieldInput.setAttribute("size", "30");


            var fieldColumn = document.createElement("td");
            fieldColumn.appendChild(fieldInput);

            //fieldColumn.innerHTML += "<a onclick=></a>";
            var hrefForDelete = document.createElement("button");
            hrefForDelete.innerHTML = "удалить";
            hrefForDelete.setAttribute("width", "15");
            hrefForDelete.setAttribute("onclick", "delFunct(this);");
            fieldColumn.appendChild(hrefForDelete);

            var newInputRow = document.createElement("tr");
            newInputRow.appendChild(labelColumn);
            newInputRow.appendChild(fieldColumn);

            lastTr.id = null;
            newInputRow.id = 'last_tr';

            lastTr.parentNode.insertBefore(newInputRow, lastTr.nextSibling);

            e.selectedIndex = 0;

        }
    </script>

    <form id='Student' method="post" name='Student' action='save' charset='utf-8' onsubmit="return checkStudentform(this)">
        <input type="hidden" name="entity" value="${entity}">
        <input type="hidden" name="pageTitle" value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><fmt:message key='sex'/></td>
                <td>
                    <label for="male"><fmt:message key='male'/></label>
                    <input id='male' type='radio' name='sex' value="1" <c:if test="${bean.sex.id==1}">checked='checked'</c:if>>
                    <label for="female"><fmt:message key='female'/></label>
                    <input id='female' type='radio' name='sex' value="2" <c:if test="${bean.sex.id==2}">checked='checked'</c:if>> 
                    <div class='errorMessage'>${messageMap.sex}</div>
                </td></tr>  
            <tr><td><label for='lastNameRu'><fmt:message key='lastNameRu'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='lastNameRu' type='text' name='lastNameRu' size='40' value='${bean.lastNameRu}'>
                    <div class='errorMessage'>${messageMap.lastNameRu}</div></td></tr>
            <tr><td><label for='firstNameRu'><fmt:message key='firstNameRu'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='firstNameRu' type='text' name='firstNameRu' size='40' value='${bean.firstNameRu}'>
                    <div class='errorMessage'>${messageMap.firstNameRu}</div></td></tr>
            <tr><td><label for='patronicNameRu'><fmt:message key='patronicNameRu'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='patronicNameRu' type='text' name='patronicNameRu' size='40' value='${bean.patronicNameRu}'>
                    <div class='errorMessage'>${messageMap.patronicNameRu}</div></td></tr>
            <tr><td><label for='lastNameEn'><fmt:message key='lastNameEn'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='lastNameEn' type='text' name='lastNameEn' size='40' value='${bean.lastNameEn}'>
                    <div class='errorMessage'>${messageMap.lastNameEn}</div></td></tr>
            <tr><td><label for='firstNameEn'><fmt:message key='firstNameEn'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='firstNameEn' type='text' name='firstNameEn' size='40' value='${bean.firstNameEn}'>
                    <div class='errorMessage'>${messageMap.firstNameEn}</div></td></tr>
            <tr><td><label for='patronicNameEn'><fmt:message key='patronicNameEn'/></label></td>
                <td><INPUT maxlength='40' id='patronicNameEn' type='text' name='patronicNameEn' size='40' value='${bean.patronicNameEn}'></td></tr>
            <tr><td><label for='dateOfBirth'><fmt:message key='dateOfBirth'/></label></td>
                <td><INPUT id='dateOfBirth' type='text' name='dateOfBirth' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event,this);" 
                           value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dateOfBirth}"/>'>
                    <div class='errorMessage'>${messageMap.dateOfBirth}</div></td></tr>


            <c:choose>
                <c:when test="${requestScope.userPath eq '/create' or requestScope.userPath eq '/save'}">
                    <tr><td><label for='emailOffice'><fmt:message key='emailOffice'/></label>
                        </td>
                        <td><INPUT maxlength='40' id='emailOffice' type='email' name='emailOffice' size='40' value=''>
                            <div class='errorMessage'>${messageMap.emailOffice}</div></td></tr>
                    <tr><td><label for='emailHome'><fmt:message key='emailHome'/></label></td>
                        <td><INPUT maxlength='40' id='emailHome' type='email' name='emailHome' size='40' value=''>
                            <div class="errorMessage">${messageMap.emailHome}</div></td></tr>
                    <tr><td><label for='emailAdd'><fmt:message key='emailAdd'/></label></td>
                        <td><INPUT maxlength='40' id='emailAdd' type='email' name='emailAdd' size='40' value=''>
                            <div class='errorMessage'>${messageMap.emailAdd}</div></td></tr>
                    <tr id="last_tr">
                        <td></td>
                        <td>
                            <select id="mailSelect" onclick="selectEmail();">
                                <option value="">--- Добавить email ---</option>
                                <option value="emailOffice"><fmt:message key='emailOffice'/></option>
                                <option value="emailHome"><fmt:message key='emailHome'/></option>
                                <option value="emailAdd"><fmt:message key='emailAdd'/></option>
                            </select>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr><td><label for='email'><fmt:message key='email'/></label></td>
                        <td>
                            <a href="create?entity=email&student=${bean.id}"><fmt:message key='add'/> email</a></br>
                            <c:forEach  var="mail" items="${bean.emails}">
                                ${mail.email} (${mail.emailType.name}, <fmt:message key='isActual'/>:
                                <c:choose><c:when test="${mail.isActual}"><fmt:message key='yes'/></c:when><c:otherwise><fmt:message key='no'/>, </c:otherwise></c:choose>
                                <fmt:message key='subscribe'/>: 
                                <c:choose><c:when test="${mail.subscribe}"><fmt:message key='yes'/>)</c:when><c:otherwise><fmt:message key='no'/>)</c:otherwise></c:choose>
                                <a href="edit?entity=email&id=${mail.id}"><fmt:message key='edit'/></a>        
                                <a href='delete?entity=email&id=${mail.id}&backPage=${param.entity}&backAction=edit&backEntityId=${bean.id}'><fmt:message key='delete'/></a>
                                <br/>   
                            </c:forEach>
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>


            <c:choose>

                <c:when test="${requestScope.userPath eq '/edit' or requestScope.userPath eq '/delete'}"> 
                    <tr><td><label for='studentOrganization'><fmt:message key='organization'/></label></td>
                        <td>
                            <a href="create?entity=student_organization&student=${bean.id}"><fmt:message key='add_organization'/></a></br>
                            <c:forEach  var="stdOrg" items="${sort: sortByDate(bean.studentOrganizations)}">
                                ${stdOrg.organization.name} (<fmt:message key='rnn'/>: ${stdOrg.organization.rnn},  <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${stdOrg.date}" />), 
                                <a href="edit?entity=student_organization&id=${stdOrg.id}"><fmt:message key='edit'/></a>        
                                <a href='delete?entity=student_organization&id=${stdOrg.id}&backPage=${param.entity}&backAction=edit&backEntityId=${bean.id}'><fmt:message key='delete'/></a>
                                <br/>   
                            </c:forEach>
                        </td>
                    </tr>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>

            <tr><td><label for='phoneHome'><fmt:message key='phoneHome'/></label></td>
                <td><INPUT maxlength='40' id='phoneHome' type='text' name='phoneHome' size='40' value='${bean.phoneHome}'></td></tr>
            <tr><td><label for='phoneMobile1'><fmt:message key='phoneMobile1'/></label></td>
                <td><INPUT maxlength='40' id='phoneMobile1' type='text' name='phoneMobile1' size='40' value='${bean.phoneMobile1}'></td></tr>
            <tr><td><label for='phoneMobile2'><fmt:message key='phoneMobile2'/></label></td>
                <td><INPUT maxlength='40' id='phoneMobile2' type='text' name='phoneMobile2' size='40' value='${bean.phoneMobile2}'></td></tr>
            <tr><td><label for='phoneOffice'><fmt:message key='phoneOffice'/></label></td>
                <td><INPUT maxlength='40' id='phoneOffice' type='text' name='phoneOffice' size='40' value='${bean.phoneOffice}'></td></tr>
            <tr><td><label for='skype'><fmt:message key='skype'/></label></td>
                <td><INPUT maxlength='40' id='skype' type='text' name='skype' size='40' value='${bean.skype}'></td></tr>
            <tr><td><label for='icq'><fmt:message key='icq'/></label></td>
                <td><INPUT maxlength='40' id='icq' type='text' name='icq' size='40' value='${bean.icq}'></td></tr>
            <tr><td><label for='mailruAgent'><fmt:message key='mailruAgent'/></label></td>
                <td><INPUT maxlength='40' id='mailruAgent' type='text' name='mailruAgent' size='40' value='${bean.mailruAgent}'></td></tr>
            <tr><td><label for='comments'><fmt:message key='comments'/></label></td>
                <td><INPUT maxlength='100' id='comments' type='text' name='comments' size='40' value='${bean.comments}'></td></tr>
            <tr><td><label for='photo'><fmt:message key='photo'/></label></td>
                <td><INPUT maxlength='40' id='photo' type='text' name='photo' size='40' value='${bean.photo}'></td></tr>
            <tr><td><label for='personVueIdent'><fmt:message key='personVueIdent'/></label></td>
                <td><INPUT maxlength='40' id='personVueIdent' type='text' name='personVueIdent' size='40' value='${bean.personVueIdent}'></td></tr>
            <tr><td><label for='prometricIdent'><fmt:message key='prometricIdent'/></label></td>
                <td><INPUT maxlength='40' id='prometricIdent' type='text' name='prometricIdent' size='40' value='${bean.prometricIdent}'></td></tr>
            <tr><td><label for='oracleLogin'><fmt:message key='oracleLogin'/></label></td>
                <td><INPUT maxlength='40' id='oracleLogin' type='text' name='oracleLogin' size='40' value='${bean.oracleLogin}'></td></tr>
            <tr><td><label for='microsoftLogin'><fmt:message key='microsoftLogin'/></label></td>
                <td><INPUT maxlength='40' id='microsoftLogin' type='text' name='microsoftLogin' size='40' value='${bean.microsoftLogin}'></td></tr>
            <tr><td><input type='submit' name='submitButton'  class='buttonEditForm' value='<fmt:message key='save'/>'/></td>
                <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td></tr>
        </table>
        <input type="hidden" name="required" value="<%="sex:reqTrue:typeNumberInt^"
                + "lastNameRu:reqTrue:typeText^"
                + "firstNameRu:reqTrue:typeText^"
                + "patronicNameRu:reqTrue:typeText^"
                + "lastNameEn:reqTrue:typeText^"
                + "firstNameEn:reqTrue:typeText^"
                + "emailOffice:reqFalse:typeEmail^"
                + "emailHome:reqFalse:typeEmail^"
                + "emailAdd:reqFalse:typeEmail^"
                + "dateOfBirth:reqFalse:typeDate"%>"/>


    </form>

</div>





