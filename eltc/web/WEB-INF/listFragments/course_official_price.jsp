<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='courseOfficial'/></td>
<td><fmt:message key='date'/></td>
<td><fmt:message key='price'/></td>
<td><fmt:message key='currency'/></td>
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
        <td>${std.courseOfficial.code} (${std.courseOfficial.course.nameRu})</td>
        <td> <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.date}" /></td>
        <td>${std.price}</td>
        <td>${std.currency.name}</td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>