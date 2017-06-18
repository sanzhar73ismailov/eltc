
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

    <form id='Email' method='post' name='Email' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">

        <c:if test="${student != null}">
            <input type='hidden' name='student' value="${student.id}">
        </c:if>
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='email'><fmt:message key='email'/></label></td>
                <td><input required="required" class='inpReq' maxlength='40' id='codeOwn' type='email' name='email' size='40' value='${bean.email}'/>
                    <div class='errorMessage'>${messageMap.email}</div></td></tr>

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
                    </td>

                </tr>  
            </c:if>



            <tr><td><label for='emailType'><fmt:message key='emailType'/></label></td>
                <td>
                    <select required="required" class='inpReq' name='emailType' id='category'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${emailTypes}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.emailType.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.emailType}</div>
                </td></tr>
            <tr><td><label for='isActual'><fmt:message key='isActual'/></label></td>
                <td><input id='isActual' type='checkbox' name='isActual' size='40' value="ON" <c:if test="${bean.isActual or bean.id==null}">checked="checked"</c:if>/>
                    <div class='errorMessage'>${messageMap.isActual}</div></td></tr>
            <tr><td><label for='subscribe'><fmt:message key='subscribe'/></label></td>
                <td><input id='subscribe' type='checkbox' name='subscribe' size='40' value="ON" <c:if test="${bean.subscribe or bean.id==null}">checked="checked"</c:if>/>
                    <div class='errorMessage'>${messageMap.subscribe}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="email:reqTrue:typeEmail^"
                + "student:reqTrue:typeDic^"
                + "emailType:reqTrue:typeDic^"
                + "isActual:reqFalse:typeText^"
                + "subscribe:reqFalse:typeText"%>'/>
    </form>
</div>





