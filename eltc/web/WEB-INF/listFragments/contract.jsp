<%@include file="../jspf/import.jspf" %>
<td><fmt:message key='id'/></td>
<td><fmt:message key='organization'/></td>
<td><fmt:message key='number'/></td>
<td><fmt:message key='numberInternal'/></td>
<td><fmt:message key='date'/></td>
<td> <fmt:message key='description'/></td>
<td> <fmt:message key='download'/></td>
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
        <td>${std.number}</td>
        <td>${std.numberInternal}</td>
        <td> <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${std.date}" /></td>
        <td>${std.description}</td>
        <td>
            <c:if test="${std.pdfFile != null}">
                <a href=download?entity=contract&id=${std.id}&type=pdf>
                    <img src="<c:url value='images/pdf.png'/>" 
                         alt ="<fmt:message key='download'/> pdf" width="25" height="25" /></a>
                <c:if test="${std.wordFile != null}"><br/></c:if>
            </c:if>
            <c:if test="${std.wordFile != null}">
                <a href=download?entity=contract&id=${std.id}&type=word>
                    <img src="<c:url value='images/doc.png'/>" 
                         alt ="<fmt:message key='download'/> doc"  width="25" height="25" /></a>
                </c:if>
        </td>
        <%@include file="/WEB-INF/jspf/fragmentForList.jspf" %>
    </tr>
</c:forEach>