<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='City' method="post" name='City' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='name'><fmt:message key='name'/></label></td>
                <td><input required="required" class='inpReq' maxlength='100' id='name' type='text' name='name' size='40' value='${bean.name}'/>
                    <div class='errorMessage'>${messageMap.name}</div></td></tr>

            <tr><td><label for='country'><fmt:message key='country'/></label></td>
                <td>
                    <select required="required" class='inpReq' name='country' id='country'>
                        <option value=""><fmt:message key='not_selected'/></option>
                        <c:forEach items="${countries}" var="item">
                            <option value='${item.id}' <c:if test="${item.id==bean.country.id}">selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.country}</div>

                </td></tr>

            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
               <input type='hidden' name='required' value='<%="country:reqTrue:typeDic^"
                       + "name:reqTrue:typeText"%>'/>
    </form>



</div>





