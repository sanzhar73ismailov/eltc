<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    public void jspInit() {
    }

    public void jspDestroy() {
    }

%>
<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>
<div id="container">
    <jsp:useBean id="bean" class="java.lang.Object"  scope="request"/>

    <h3>${pageTitle}: </h3> 
    <a href="show?entity=${entity}"><fmt:message key='list'/></a>
    <a href="create?entity=${entity}"><fmt:message key='add'/></a>
    <a href="edit?entity=${entity}&id=${bean.id}"><fmt:message key='edit'/></a>
    <a href="delete?entity=${entity}&id=${bean.id}" onclick="return confirmDelete();"><fmt:message key='delete'/></a>
    <%= eltc.web.ShowBeanAsWeb.getSetWebString(bean)%>
</div>
