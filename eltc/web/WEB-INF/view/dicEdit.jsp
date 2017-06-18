
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



    <form id='Dictionary' method="post" name='Dictionary' action='save' charset='utf-8'>
        <input type="hidden" name="entity" value="${entity}">
        <input type="hidden" name="pageTitle" value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='name'><fmt:message key='name'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='name' type='text' name='name' size='40' value='${bean.name}'/>
                    <div class='errorMessage'>${messageMap.name}</div></td></tr>
            <tr><td><input type='submit' name='submitButton'  class='buttonEditForm' value='<fmt:message key='save'/>'/></td>
                <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td></tr>
        </table>

        <input type='hidden' name='required' value='<%="name:reqTrue:typeText"%>'/>
    </form>


</div>





