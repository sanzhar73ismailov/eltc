
<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='CourseOfficialPrice' method='post' name='CourseOfficialPrice' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='currency'><fmt:message key='currency'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='currency' id='currency'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${currencies}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.currency.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.currency}</div>
                </td></tr>
            <tr><td><label for='courseOfficial'><fmt:message key='courseOfficial'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='courseOfficial' id='courseOfficial'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${courseOfficials}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.courseOfficial.id}'>selected='selected'</c:if> >${item.code} (${item.course.nameRu})</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.courseOfficial}</div>
                </td></tr>
            <tr><td><label for='date'><fmt:message key='date'/></label></td>
                <td><input required='required' class='inpReq' id='date' type='text' name='date' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event,this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.date}"/>'/>
                    <div class='errorMessage'>${messageMap.date}</div></td></tr>
            <tr><td><label for='price'><fmt:message key='price'/></label></td>
                <td><input id='price' type='text' name='price' size='40' value='${bean.price}'/>
                    <div class='errorMessage'>${messageMap.price}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="currency:reqTrue:typeDic^"
                + "courseOfficial:reqTrue:typeDic^"
                + "date:reqTrue:typeDate^"
                + "price:reqFalse:typeNumberDouble"%>'/>
    </form>



</div>





