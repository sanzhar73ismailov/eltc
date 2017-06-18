<%@ page pageEncoding="UTF-8" %>
<%@include file="../jspf/import.jspf" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf">
    <jsp:param name="par1" value="val1 from index"/>
    <jsp:param name="par2" value="val2 from index"/>
</jsp:include>
<div id="container">
    
    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if> 
        <p/>
        

        <h3>Необходимо настроить eltc.web.pageNavig.FabricaForPageNavigator.java!</h3>
        
        
</div>
    
    
    
    
