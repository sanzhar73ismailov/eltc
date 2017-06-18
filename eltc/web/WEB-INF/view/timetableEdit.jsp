<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



    <form id='Timetable' method='post' name='Timetable' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='vendor'><fmt:message key='toFilterByVendor'/></label></td>
                <td>
                    <select name='vendor' id='vendor' onchange="forTimeTableFilter();">
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${vendors}' var='item'>
                            <option value='${item.id}'>${item.name}</option>
                        </c:forEach>
                    </select>
                    <br/>
                  </td></tr>            
            <tr><td><label for='category'><fmt:message key='toFilterByCategory'/></label></td>
                <td>
                    <select name='category' id='category' onchange="forTimeTableFilter();">
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${categories}' var='item'>
                            <option value='${item.id}'>${item.name}</option>
                        </c:forEach>
                    </select>
                </td></tr>            
            <tr><td><label for='course'><fmt:message key='course'/></label></td>
                <td>
                    <select required='required'  class='inpReq' name='course' id='course'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${courses}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.course.id}'>selected='selected'</c:if> >${item.codeOwn} ${item.nameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.course}</div>
                </td></tr>
            <tr><td><label for='trainerByTrainerOfficialId'><fmt:message key='trainerByTrainerOfficialId'/></label></td>
                <td>
                    <select  required='required' class='inpReq' name='trainerByTrainerOfficialId' id='trainerByTrainerOfficialId'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${trainers}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.trainerByTrainerOfficialId.id}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.trainerByTrainerOfficialId}</div>
                </td></tr>
            <tr><td><label for='trainerByTrainerFactId'><fmt:message key='trainerByTrainerFactId'/></label></td>
                <td>
                    <select  required='required' class='inpReq' name='trainerByTrainerFactId' id='trainerByTrainerFactId'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${trainers}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.trainerByTrainerFactId.id}'>selected='selected'</c:if> >${item.lastNameRu} ${item.firstNameRu}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.trainerByTrainerFactId}</div>
                </td></tr>
            <tr><td><label for='auditory'><fmt:message key='auditory'/></label></td>
                <td>
                    <select  required='required' class='inpReq' name='auditory' id='auditory'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${auditories}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.auditory.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.auditory}</div>
                </td></tr>
            <tr><td><label for='date'><fmt:message key='dateOfCourseStart'/></label></td>
                <td><input required='required' class='inpReq' id='date' type='text' name='date' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event, this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.date}"/>'/>
                    <div class='errorMessage'>${messageMap.date}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="course:reqTrue:typeDic^"
                + "trainerByTrainerOfficialId:reqTrue:typeDic^"
                + "trainerByTrainerFactId:reqTrue:typeDic^"
                + "auditory:reqTrue:typeDic^"
                + "date:reqTrue:typeDate"%>'/>
    </form>




</div>





