<%@page pageEncoding="UTF-8" %>
<%!
    public void jspInit() {
    }

    public void jspDestroy() {
    }
%>
<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">

    <h3>${pageTitle} <div><a href="create?entity=${entity}"><fmt:message key='add'/></a></div></h3>
    <div style="background-color: coral; width: 400px " > ${requestScope['exception'].message}</div>


    <table border="1">
        <td>№</td>
        <td><fmt:message key='id'/></td>
        <td><fmt:message key='course'/></td>
        <td><fmt:message key='trainerByTrainerOfficialId'/></td>
        <td><fmt:message key='trainerByTrainerFactId'/></td>
        <td><fmt:message key='auditory'/></td>
        <td><fmt:message key='date'/></td>
        <td>-</td>
        <td>-</td>
        <td>-</td>

        <c:forEach items="${beans}" var="std" varStatus="varStat">
            <tr>
                 <td>${param.pageSize * (param.pageNumber-1) + varStat.count}</td>
                <td>${std.id}</td>
                <td>${std.course.nameRu} (${std.course.codeOwn})</td>
                <td>${std.trainerByTrainerOfficialId.lastNameRu} ${std.trainerByTrainerOfficialId.firstNameRu}</td>
                <td>${std.trainerByTrainerFactId.lastNameRu} ${std.trainerByTrainerFactId.firstNameRu}</td>
                <td>${std.auditory.name}</td>
                <td> <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.date}" /></td>
                 <jsp:include page="/WEB-INF/jspf/fragmentForList.jspf">
                   <jsp:param name="entity" value="${entity}"/>
                   <jsp:param name="id" value="${std.id}"/>
               </jsp:include>
            </tr>
        </c:forEach>
    </table>
</div>





