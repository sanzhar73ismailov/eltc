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
        <td><fmt:message key='typeOwnership'/></td>
        <td><fmt:message key='name'/></td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
  
        <c:forEach items="${beans}" var="std" varStatus="varStat">
            <tr>
                 <td>${param.pageSize * (param.pageNumber-1) + varStat.count}</td>
                <td>${std.id}</td>
                <td>${std.typeOwnership.name}</td>
                <td>${std.name}</td>
                 <jsp:include page="/WEB-INF/jspf/fragmentForList.jspf">
                   <jsp:param name="entity" value="${entity}"/>
                   <jsp:param name="id" value="${std.id}"/>
               </jsp:include>
            </tr>
        </c:forEach>
    </table>
</div>




