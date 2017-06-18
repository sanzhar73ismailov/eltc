
<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  
    <form id='Course' method='post' name='Course' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='vendor'><fmt:message key='vendor'/></label></td>
                <td>
                    <select required="required" class='inpReq' name='vendor' id='vendor'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${vendors}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.vendor.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.vendor}</div>
                </td></tr>
            <tr><td><label for='category'><fmt:message key='category'/></label></td>
                <td>
                    <select required="required" class='inpReq' name='category' id='category'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${сategories}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.category.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.category}</div>
                </td></tr>
            <tr><td><label for='codeOwn'><fmt:message key='codeOwn'/></label></td>
                <td><input required="required" class='inpReq' maxlength='20' id='codeOwn' type='text' name='codeOwn' size='40' value='${bean.codeOwn}'/>
                    <div class='errorMessage'>${messageMap.codeOwn}</div></td></tr>
            <tr><td><label for='nameOriginal'><fmt:message key='nameOriginal'/></label></td>
                <td><input required="required"  class='inpReq' maxlength='255' id='nameOriginal' type='text' name='nameOriginal' size='40' value='${bean.nameOriginal}'/>
                    <div class='errorMessage'>${messageMap.nameOriginal}</div></td></tr>
            <tr><td><label for='nameRu'><fmt:message key='nameRu'/></label></td>
                <td><input required="required" class='inpReq' maxlength='255' id='nameRu' type='text' name='nameRu' size='40' value='${bean.nameRu}'/>
                    <div class='errorMessage'>${messageMap.nameRu}</div></td></tr>
            <tr><td><label for='discriptionEn'><fmt:message key='discriptionEn'/></label></td>
                <td><input required="required" class='inpReq' maxlength='65535' id='discriptionEn' type='text' name='discriptionEn' size='40' value='${bean.discriptionEn}'/>
                    <div class='errorMessage'>${messageMap.discriptionEn}</div></td></tr>
            <tr><td><label for='discriptionRu'><fmt:message key='discriptionRu'/></label></td>
                <td><input required="required" class='inpReq' maxlength='65535' id='discriptionRu' type='text' name='discriptionRu' size='40' value='${bean.discriptionRu}'/>
                    <div class='errorMessage'>${messageMap.discriptionRu}</div></td></tr>
            <tr><td><label for='durationDays'><fmt:message key='durationDays'/></label></td>
                <td><input required="required" class='inpReq' id='durationDays' type='text' name='durationDays' size='40' value='${bean.durationDays}'/>
                    <div class='errorMessage'>${messageMap.durationDays}</div></td></tr>
            <tr><td><label for='durationHours'><fmt:message key='durationHours'/></label></td>
                <td><input required="required" class='inpReq' id='durationHours' type='text' name='durationHours' size='40' value='${bean.durationHours}'/>
                    <div class='errorMessage'>${messageMap.durationHours}</div></td></tr>
            <tr><td><label for='additionalInfo'><fmt:message key='additionalInfo'/></label></td>
                <td><input maxlength='100' id='additionalInfo' type='text' name='additionalInfo' size='40' value='${bean.additionalInfo}'/>
                    <div class='errorMessage'>${messageMap.additionalInfo}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="vendor:reqTrue:typeDic^"
                + "category:reqTrue:typeDic^"
                + "codeOwn:reqTrue:typeText^"
                + "nameOriginal:reqTrue:typeText^"
                + "nameRu:reqTrue:typeText^"
                + "discriptionEn:reqTrue:typeText^"
                + "discriptionRu:reqTrue:typeText^"
                + "durationDays:reqTrue:typeText^"
                + "durationHours:reqTrue:typeText^"
                + "additionalInfo:reqFalse:typeText"%>'/>
    </form>






</div>





