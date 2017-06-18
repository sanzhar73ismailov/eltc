<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  

    <form id='TypeOwnership' method='post' name='TypeOwnership' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='name'><fmt:message key='name'/></label></td>
                <td><input  class='inpReq' maxlength='20' id='name' type='text' name='name' size='40' value='${bean.name}'/>
                    <div class='errorMessage'>${messageMap.name}</div></td></tr>
            <tr><td><label for='nameFull'><fmt:message key='nameFull'/></label></td>
                <td><input  class='inpReq' maxlength='100' id='nameFull' type='text' name='nameFull' size='40' value='${bean.nameFull}'/>
                    <div class='errorMessage'>${messageMap.nameFull}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
               <input type='hidden' name='required' value='<%="name:reqTrue:typeText^"
                + "nameFull:reqTrue:typeText"%>'/>
    </form>



</div>





