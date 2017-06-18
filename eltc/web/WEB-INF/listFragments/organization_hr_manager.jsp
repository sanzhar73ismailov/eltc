<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='organization'/></td>
<td><fmt:message key='hrManager'/></td>
<td><fmt:message key='isActual'/></td>
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
        <td>${std.organization.name}</td>
        <td>${std.hrManager.lastNameRu} ${std.hrManager.firstNameRu}</td>
        <td><c:choose>
                <c:when test="${std.isActual==true}">
                    <fmt:message key='yes'/>
                </c:when>
                <c:otherwise>
                    <fmt:message key='no'/>
                </c:otherwise>
            </c:choose>
        </td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>