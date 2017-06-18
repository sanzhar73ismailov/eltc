<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='lastNameRu'/></td>
<td><fmt:message key='firstNameRu'/></td>
<td><fmt:message key='patronicNameRu'/></td>
<td> <fmt:message key='dateOfBirth'/></td>
<td> <fmt:message key='email'/></td>
<td> <fmt:message key='comments'/></td>
<td>-</td>
<td>-</td>
<td>-</td>
</tr>
<c:forEach items="${beans}" var="std" varStatus="varStat">
    <c:choose>
        <c:when test="${(varStat.count % 2) == 0}">
            <c:set var="trClass" value="contentfont c1"/>    
        </c:when>
        <c:otherwise>
            <c:set var="trClass" value="contentfont c2"/>
        </c:otherwise>
    </c:choose>
    <tr class='${trClass}'>
        <td>${param.pageSize * (param.pageNumber-1) + varStat.count}</td>
        <td>${std.id}</td>
        <td>${std.lastNameRu}</td>
        <td>${std.firstNameRu}</td>
        <td>${std.patronicNameRu}</td>
        <td> <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.dateOfBirth}" /></td>
        <td>
            <c:forEach  var="mail" items="${std.emails}">
                ${mail.email} (${mail.emailType.name}                 
                <br/>   
            </c:forEach>
        </td>
        <td>${std.comments}</td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    
    </tr>
</c:forEach>