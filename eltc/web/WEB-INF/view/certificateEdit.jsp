
<%@page import="java.util.List"%>
<%@page import="domain.Student"%>
<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='Certificate' method='post' name='Certificate' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='vendor'><fmt:message key='vendor'/></label></td>
                <td>
                    <select required='required'  class='inpReq' name='vendor' id='vendor'>
                        <option value=''><fmt:message key='not_selected'/></option><c:forEach items='${vendors}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.vendor.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.vendor}</div>
                </td></tr>
            <tr><td><label for='code'><fmt:message key='code'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='code' type='text' name='code' size='40' value='${bean.code}'/>
                    <div class='errorMessage'>${messageMap.code}</div></td></tr>
            <tr><td><label for='name'><fmt:message key='name'/></label></td>
                <td><input required='required' class='inpReq' maxlength='255' id='name' type='text' name='name' size='40' value='${bean.name}'/>
                    <div class='errorMessage'>${messageMap.name}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="vendor:reqTrue:typeDic^"
                + "code:reqTrue:typeText^"
                + "name:reqTrue:typeText"%>'/>
    </form>



</div>





