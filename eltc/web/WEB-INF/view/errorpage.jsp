<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<jsp:include page="/WEB-INF/jspf/lefter.jspf">
    <jsp:param name="par1" value=""/>
    <jsp:param name="par2" value=""/>
</jsp:include>
<div id class="container">
    <%
        Exception ex = (Exception) request.getAttribute("except");
    %>
    <h1>Страница ошибок</h1>
    <h2> Сообщение об ошибке: 
        <c:out value="${ex.message}" default="нет сообщений" escapeXml="true"/>
    </h2>
    <p/>

    <%
        out.print("<p>Трассировка:<br/>");
        // out.print("Тип ошибки "+ex);
        if (ex != null) {
            StackTraceElement[] st = ex.getStackTrace();
            for (StackTraceElement s : st) {
                out.print(s.toString() + "<br/>");
            }
        }

    %>

</div>