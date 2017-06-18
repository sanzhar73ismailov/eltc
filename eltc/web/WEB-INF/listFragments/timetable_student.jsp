<%@include file="../jspf/import.jspf" %>
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
</tr>
<c:forEach items="${beans}" var="std" varStatus="varStat">
    <c:choose>
        <c:when test="${varStat.count % 2 == 0}">
            <c:set var="trClass" value="contentfont c1"/>    
        </c:when>
        <c:otherwise>
            <c:set var="trClass" value="contentfont c2"/>
        </c:otherwise>
    </c:choose>
    <tr class='${trClass}'>
        <td>${param.pageSize * (param.pageNumber-1) + varStat.count}</td>
        <td>${std.id}</td>
        <td>${std.manager.lastNameRu} ${std.manager.firstNameRu}</td>
        <td>${std.courseOfficial.code} ${std.courseOfficial.courseType.name} ${std.courseOfficial.course.nameRu}</td>
        <td>${std.student.lastNameRu} ${std.student.firstNameRu} ${std.student.patronicNameRu},  <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.student.dateOfBirth}"/> </td>
        <td>${std.timetable.course.nameRu} ${std.timetable.auditory.name} <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.timetable.date}"/></td>
        <td>№${std.contract.number} от <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.contract.date}"/> 
            (${std.contract.organization.name})</td>
        <td>${std.priceFact}</td>
        <td><a href="create?entity=${entity}&change=student&id=${std.id}"><fmt:message key='addButWithAnotherStudent'/></a></td>
            <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>