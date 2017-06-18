<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='vendor'/></td>
<td><fmt:message key='category'/></td>
<td><fmt:message key='codeOwn'/></td>
<td><fmt:message key='nameOriginal'/></td>
<td><fmt:message key='nameRu'/></td>
<td><fmt:message key='durationDays'/></td>
<td><fmt:message key='durationHours'/></td>
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
        <td>${std.vendor.name}</td>
        <td>${std.category.name}</td>
        <td>${std.codeOwn}</td>
        <td>${std.nameOriginal}</td>
        <td>${std.nameRu}</td>
        <td>${std.durationDays}</td>
        <td>${std.durationHours}</td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>