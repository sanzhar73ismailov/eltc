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



    <form id='Student' method="post" name='Student' action='save' charset='utf-8' enctype="multipart/form-data">
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
                    </td></tr>  
                <tr><td><label for='lastNameRu'><fmt:message key='lastNameRu'/></label></td>
                <td><INPUT required='required'  class='inpReq' maxlength='40' id='lastNameRu' type='text' name='lastNameRu' size='40' value='${bean.lastNameRu}'>
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
                <td><INPUT required='required' class='inpReq' id='dateOfBirth' type='text' name='dateOfBirth' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event,this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.dateOfBirth}"/>'>
                    <div class='errorMessage'>${messageMap.dateOfBirth}</div></td></tr>
            <tr><td><label for='emailOffice'><fmt:message key='emailOffice'/></label></td>
                <td><INPUT required='required' class='inpReq' maxlength='40' id='emailOffice' type='text' name='emailOffice' size='40' value='${bean.emailOffice}'>
                    <div class='errorMessage'>${messageMap.emailOffice}</div></td></tr>
            <tr><td><label for='emailHome'><fmt:message key='emailHome'/></label></td>
                <td><INPUT maxlength='40' id='emailHome' type='text' name='emailHome' size='40' value='${bean.emailHome}'>
                    <div class="errorMessage">${messageMap.emailHome}</div></td></tr>
            <tr><td><label for='emailAdd'><fmt:message key='emailAdd'/></label></td>
                <td><INPUT maxlength='40' id='emailAdd' type='text' name='emailAdd' size='40' value='${bean.emailAdd}'>
                    <div class='errorMessage'>${messageMap.emailAdd}</div></td></tr>
            <tr><td><label for='phoneHome'><fmt:message key='phoneHome'/></label></td>
                <td><INPUT maxlength='40' id='phoneHome' type='text' name='phoneHome' size='40' value='${bean.phoneHome}'></td></tr>
            <tr><td><label for='phoneMobile1'><fmt:message key='phoneMobile1'/></label></td>
                <td><INPUT required='required' maxlength='40' id='phoneMobile1' type='text' name='phoneMobile1' size='40' value='${bean.phoneMobile1}'></td></tr>
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
            
            <myTag:tag_input_file filePrefixName="cvDoc"  fileProperty="${bean.cvDocFile}"/>
          
            <myTag:tag_input_file filePrefixName="photo"  fileProperty="${bean.photoFile}"/>
            
             <tr><td><input type='submit' name='submitButton'  class='buttonEditForm' value='<fmt:message key='save'/>' onclick="return checkFileSize({cvDocFile: 5, photoFile: 10});"/></td>
                <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td></tr>
        </table>
        <input type="hidden" name="required" value="<%="sex:reqTrue:typeNumberInt^"
                + "lastNameRu:reqTrue:typeText^"
                + "firstNameRu:reqTrue:typeText^"
                + "patronicNameRu:reqTrue:typeText^"
                + "lastNameEn:reqTrue:typeText^"
                + "firstNameEn:reqTrue:typeText^"
                + "emailOffice:reqTrue:typeEmail^"
                + "emailHome:reqFalse:typeEmail^"
                + "emailAdd:reqFalse:typeEmail^"
                + "dateOfBirth:reqTrue:typeDate"%>"/>


    </form>

</div>





