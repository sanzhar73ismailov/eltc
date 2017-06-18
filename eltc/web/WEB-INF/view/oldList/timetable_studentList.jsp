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
        <td><fmt:message key='manager'/></td>
        <td><fmt:message key='courseOfficial'/></td>
        <td><fmt:message key='student'/></td>
        <td><fmt:message key='timetable'/></td>
        <td><fmt:message key='contract'/></td>
        <td><fmt:message key='priceFact'/></td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
 
        <c:forEach items="${beans}" var="std" varStatus="varStat">
            <tr>
                 <td>${param.pageSize * (param.pageNumber-1) + varStat.count}</td>
                <td>${std.id}</td>
                <td>${std.manager.lastNameRu} ${std.manager.firstNameRu}</td>
                <td>${std.courseOfficial.code} ${std.courseOfficial.courseType.name} ${std.courseOfficial.course.nameRu}</td>
                <td>${std.student.lastNameRu} ${std.student.firstNameRu} ${std.student.patronicNameRu},  ${std.student.dateOfBirth} </td>
                <td>${std.timetable.course.nameRu} ${std.timetable.auditory.name} ${std.timetable.date}</td>
                <td>${std.contract.number} ${std.contract.date} ${std.contract.organization.name}</td>
                <td>${std.priceFact}</td>
                <td><a href="create?entity=${entity}&change=student&id=${std.id}"><fmt:message key='addButWithAnotherStudent'/></a></td>
                 <jsp:include page="/WEB-INF/jspf/fragmentForList.jspf">
                   <jsp:param name="entity" value="${entity}"/>
                   <jsp:param name="id" value="${std.id}"/>
               </jsp:include>
            </tr>
        </c:forEach>
    </table>
</div>





