<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='vendor'/></td>
<td><fmt:message key='code'/></td>
<td><fmt:message key='name'/></td>
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
        <td>${std.code}</td>
        <td>${std.name}</td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>




