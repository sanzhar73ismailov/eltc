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

    <form id='OrganizationHrManager' method='post' name='OrganizationHrManager' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='organization'><fmt:message key='organization'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='organization' id='organization'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${organizations}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.organization.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.organization}</div>
                </td></tr>
            <tr><td><label for='hrManager'><fmt:message key='hrManager'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='hrManager' id='hrManager'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${hrManagers}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.hrManager.id}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.hrManager}</div>
                </td></tr>
            <tr><td><label for='isActual'><fmt:message key='isActual'/></label></td>
                <td><input id='isActual' type='checkbox' name='isActual' size='40' value="ON" <c:if test="${bean.isActual or bean.id==null}">checked="checked"</c:if>/>
                    <div class='errorMessage'>${messageMap.isActual}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="organization:reqTrue:typeDic^"
                + "hrManager:reqTrue:typeDic^"
                + "isActual:reqFalse:typeText"%>'/>
    </form>





</div>





