
<%@page pageEncoding="UTF-8" %>
<%!
    public void jspInit() {
    }

    public void jspDestroy() {
    }
%>

<!-- jQuery Form Validation code -->

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>


    <%--
    <jsp:useBean id="bean" class="domain.Student" scope="request"/>
    --%>


    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='Manager' method="post" name='Manager' action='save' charset='utf-8' enctype="multipart/form-data">
        <input type="hidden" name="entity" value="${entity}">
        <input type="hidden" name="pageTitle" value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='lastNameRu'><fmt:message key='lastNameRu'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='lastNameRu' type='text' name='lastNameRu' size='40' value='${bean.lastNameRu}'/>
                    <div class='errorMessage'>${messageMap.lastNameRu}</div></td></tr>
            <tr><td><label for='firstNameRu'><fmt:message key='firstNameRu'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='firstNameRu' type='text' name='firstNameRu' size='40' value='${bean.firstNameRu}'/>
                    <div class='errorMessage'>${messageMap.firstNameRu}</div></td></tr>
            <tr><td><label for='patronicNameRu'><fmt:message key='patronicNameRu'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='patronicNameRu' type='text' name='patronicNameRu' size='40' value='${bean.patronicNameRu}'/>
                    <div class='errorMessage'>${messageMap.patronicNameRu}</div></td></tr>
            <tr><td><label for='lastNameEn'><fmt:message key='lastNameEn'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='lastNameEn' type='text' name='lastNameEn' size='40' value='${bean.lastNameEn}'/>
                    <div class='errorMessage'>${messageMap.lastNameEn}</div></td></tr>
            <tr><td><label for='firstNameEn'><fmt:message key='firstNameEn'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='firstNameEn' type='text' name='firstNameEn' size='40' value='${bean.firstNameEn}'/>
                    <div class='errorMessage'>${messageMap.firstNameEn}</div></td></tr>
            <tr><td><label for='patronicNameEn'><fmt:message key='patronicNameEn'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='patronicNameEn' type='text' name='patronicNameEn' size='40' value='${bean.patronicNameEn}'/>
                    <div class='errorMessage'>${messageMap.patronicNameEn}</div></td></tr>
            <tr><td><label for='emailOffice'><fmt:message key='emailOffice'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='emailOffice' type='text' name='emailOffice' size='40' value='${bean.emailOffice}'/>
                    <div class='errorMessage'>${messageMap.emailOffice}</div></td></tr>
            <tr><td><label for='emailHome'><fmt:message key='emailHome'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='emailHome' type='text' name='emailHome' size='40' value='${bean.emailHome}'/>
                    <div class='errorMessage'>${messageMap.emailHome}</div></td></tr>
            <tr><td><label for='emailAdd'><fmt:message key='emailAdd'/></label></td>
                <td><input maxlength='40' id='emailAdd' type='text' name='emailAdd' size='40' value='${bean.emailAdd}'/>
                    <div class='errorMessage'>${messageMap.emailAdd}</div></td></tr>
            <tr><td><label for='phoneHome'><fmt:message key='phoneHome'/></label></td>
                <td><input maxlength='40' id='phoneHome' type='text' name='phoneHome' size='40' value='${bean.phoneHome}'/>
                    <div class='errorMessage'>${messageMap.phoneHome}</div></td></tr>
            <tr><td><label for='phoneMobile1'><fmt:message key='phoneMobile1'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='phoneMobile1' type='text' name='phoneMobile1' size='40' value='${bean.phoneMobile1}'/>
                    <div class='errorMessage'>${messageMap.phoneMobile1}</div></td></tr>
            <tr><td><label for='phoneMobile2'><fmt:message key='phoneMobile2'/></label></td>
                <td><input maxlength='40' id='phoneMobile2' type='text' name='phoneMobile2' size='40' value='${bean.phoneMobile2}'/>
                    <div class='errorMessage'>${messageMap.phoneMobile2}</div></td></tr>
            <tr><td><label for='phoneOffice'><fmt:message key='phoneOffice'/></label></td>
                <td><input maxlength='40' id='phoneOffice' type='text' name='phoneOffice' size='40' value='${bean.phoneOffice}'/>
                    <div class='errorMessage'>${messageMap.phoneOffice}</div></td></tr>
            <tr><td><label for='skype'><fmt:message key='skype'/></label></td>
                <td><input maxlength='40' id='skype' type='text' name='skype' size='40' value='${bean.skype}'/>
                    <div class='errorMessage'>${messageMap.skype}</div></td></tr>
            <tr><td><label for='icq'><fmt:message key='icq'/></label></td>
                <td><input maxlength='40' id='icq' type='text' name='icq' size='40' value='${bean.icq}'/>
                    <div class='errorMessage'>${messageMap.icq}</div></td></tr>
            <tr><td><label for='mailruAgent'><fmt:message key='mailruAgent'/></label></td>
                <td><input maxlength='40' id='mailruAgent' type='text' name='mailruAgent' size='40' value='${bean.mailruAgent}'/>
                    <div class='errorMessage'>${messageMap.mailruAgent}</div></td></tr>
            
            <myTag:tag_input_file filePrefixName="cvDoc"  fileProperty="${bean.cvDocFile}"/>
          
            <myTag:tag_input_file filePrefixName="photo"  fileProperty="${bean.photoFile}"/>
            
            
            <tr><td><label for='isActual'><fmt:message key='isActual'/></label></td>
                <td><input id='isActual' type='checkbox' name='isActual' value="ON" size='40' <c:if test="${bean.isActual or bean.id==null}">checked="checked"</c:if>/>
                    <div class='errorMessage'>${messageMap.isActual}</div></td></tr>
            <tr><td><input type='submit' name='submitButton'  class='buttonEditForm' value='<fmt:message key='save'/>' onclick="return checkFileSize({cvDocFile: 5, photoFile: 10});"/></td>
                <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td></tr>
        </table>

        <input type='hidden' name='required' value='<%="lastNameRu:reqTrue:typeText^"
                + "firstNameRu:reqTrue:typeText^"
                + "patronicNameRu:reqTrue:typeText^"
                + "lastNameEn:reqTrue:typeText^"
                + "firstNameEn:reqTrue:typeText^"
                + "patronicNameEn:reqTrue:typeText^"
                + "emailOffice:reqTrue:typeEmail^"
                + "emailHome:reqTrue:typeEmail^"
                + "emailAdd:reqFalse:typeEmail^"
                + "phoneHome:reqFalse:typeText^"
                + "phoneMobile1:reqTrue:typeText^"
                + "phoneMobile2:reqFalse:typeText^"
                + "phoneOffice:reqFalse:typeText^"
                + "skype:reqFalse:typeText^"
                + "icq:reqFalse:typeText^"
                + "mailruAgent:reqFalse:typeText^"
                + "cvDocFile:reqFalse:typeText^"
                + "photoFile:reqFalse:typeText^"
                + "isActual:reqFalse:typeText"%>'/>
    </form>


</div>





