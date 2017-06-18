<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  


    <form id='TrainerSpecialization' method='post' name='TrainerSpecialization' action='save' charset='utf-8'>
       <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='specialization'><fmt:message key='specialization'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='specialization' id='specialization'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${specializations}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.specialization.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.specialization}</div>
                </td></tr>
            <tr><td><label for='trainer'><fmt:message key='trainer'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='trainer' id='trainer'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${trainers}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.trainer.id}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.trainer}</div>
                </td></tr>
            <tr><td><label for='date'><fmt:message key='date'/></label></td>
                <td><input required='required' class='inpReq' id='date' type='text' name='date' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event,this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.date}"/>'/>
                    <div class='errorMessage'>${messageMap.date}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="specialization:reqTrue:typeDic^"
                + "trainer:reqTrue:typeDic^"
                + "date:reqTrue:typeDate"%>'/>
    </form>



</div>





