<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='LFP'/></td>
<td><fmt:message key='emailOffice'/></td>
<td><fmt:message key='emailHome'/></td>
<td> <fmt:message key='phone'/></td>
<td> <fmt:message key='dateOfBirth'/></td>
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
        <td>${std.lastNameRu} ${std.firstNameRu} ${std.patronicNameRu}</td>
        <td>${std.emailOffice}</td>
        <td>${std.emailHome}</td>
        <td>${std.phoneMobile1}
            <c:if test="${std.phoneMobile2!= null}"><br/>${std.phoneMobile2}</c:if> 
            <c:if test="${std.phoneOffice!=null}"><br/><fmt:message key='phoneOffice'/>: ${std.phoneOffice}</c:if> 
            </td>
            <td> <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.dateOfBirth}" /></td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>