<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='TimetableStudent' method='post' name='TimetableStudent' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='manager'><fmt:message key='manager'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='manager' id='manager'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${managers}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.manager.id}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.manager}</div>
                </td></tr>
            <tr><td><label for='courseOfficial'><fmt:message key='courseOfficial'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='courseOfficial' id='courseOfficial'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${courseOfficials}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.courseOfficial.id}'>selected='selected'</c:if> >${item.code} ${item.courseType.name} ${item.course.nameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.courseOfficial}</div>
                </td></tr>
            <tr><td><label for='student'><fmt:message key='student'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='student' id='student'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${students}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.student.id}'>selected='selected'</c:if> >
                                ${item.lastNameRu} ${item.firstNameRu} (<fmt:message key='id'/>: ${item.id})
                            </option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.student}</div>
                </td></tr>
            <tr><td><label for='timetable'><fmt:message key='timetable'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='timetable' id='timetable'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${timetables}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.timetable.id}'>selected='selected'</c:if> >${item.course.nameRu} ${item.auditory.name} <fmt:formatDate pattern="dd/MM/yyyy" value="${item.date}"/></option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.timetable}</div>
                </td></tr>
            <tr><td><label for='contract'><fmt:message key='contract'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='contract' id='contract'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${contracts}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.contract.id}'>selected='selected'</c:if> >${item.number} ${item.date} ${item.organization.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.contract}</div>
                </td></tr>
            <tr><td><label for='priceFact'><fmt:message key='priceFact'/></label></td>
                <td><input id='priceFact' type='text' name='priceFact' size='40' value='${bean.priceFact}'/>
                    <div class='errorMessage'>${messageMap.priceFact}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="manager:reqTrue:typeDic^"
                + "courseOfficial:reqTrue:typeDic^"
                + "student:reqTrue:typeDic^"
                + "timetable:reqTrue:typeDic^"
                + "contract:reqTrue:typeDic^"
                + "priceFact:reqFalse:typeNumberDouble"%>'/>
    </form>


</div>





