
<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <br>
    <c:if test="${student != null}">
        <h3><fmt:message key='student'/>: 
            ${student.lastNameRu} ${student.firstNameRu} ${student.patronicNameRu} 
            (<fmt:message key='dateOfBirth'/>  <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${student.dateOfBirth}" />)
        </h3>
    </c:if>
    <br>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='Contract' method='post' name='form' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <c:if test="${student != null}">
            <input type='hidden' name='student' value="${student.id}">
        </c:if>
         <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>

            <c:if test="${students != null}">
                <tr><td><label for='student'><fmt:message key='student'/></label></td>
                    <td>
                        <select required="required" class='inpReq' name='student' id='student'>
                            <option value=''><fmt:message key='not_selected'/></option>
                            <c:forEach items='${students}' var='item'>
                                <option value='${item.id}' <c:if test='${item.id==bean.student.id or item.id==param.student}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu} <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${item.dateOfBirth}" /></option>
                            </c:forEach>
                        </select>
                        <div class='errorMessage'>${messageMap.student}</div>
                    </td></tr>
                </c:if>

            <tr><td><label for='findOrganization'><fmt:message key='findOrganization'/></label></td>
                <td>
                    <input id='findOrganization' type='text' name='findOrganization' size='40' placeholder="<fmt:message key='findOrganizationByNameOrRnn'/>" onkeyup="init();
                            doCompletion();"/>
                    
                    <div style="padding-top: 30px" id="numberRecordsFound"></div>
                </td>
            </tr>
            <tr><td><label for='findOrganizationsResult'><fmt:message key='findOrganizationsResult'/></label></td>
                <td>
                    <select id="findOrganizationsResult" name="organization" size="10" style="width: 600px">

                    </select>
                </td>
            </tr>

            <%--
            <tr><td><label for='organization'><fmt:message key='organization'/></label></td>
                <td>
                    <select  required='required' class='inpReq' name='organization' id='organization' style="width: 400px">
                        <option value=""><fmt:message key='not_selected'/></option>
                        <c:forEach items='${organizations}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.organization.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.organization}</div>
                </td></tr>
            --%>
            <tr><td><label for='department'><fmt:message key='department'/></label></td>
                <td><input maxlength='200' id='department' type='text' name='department' size='40' value='${bean.department}'/>
                    <div class='errorMessage'>${messageMap.department}</div></td></tr>

            <tr><td><label for='status'><fmt:message key='status'/></label></td>
                <td><input maxlength='40' id='status' type='text' name='status' size='40' value='${bean.status}'/>
                    <div class='errorMessage'>${messageMap.status}</div></td></tr>

            <tr><td><label for='date'><fmt:message key='date'/></label></td>
                <td><input required='required' class='inpReq' id='date' type='text' name='date' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event,this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.date}"/>'/>
                    <div class='errorMessage'>${messageMap.date}</div></td></tr>

            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="organization:reqTrue:typeText^"
                + "student:reqTrue:typeText^"
                + "date:reqTrue:typeDate^"
                + "department:reqFalse:typeText^"
                + "status:reqFalse:typeText"%>'/>
    </form>



</div>