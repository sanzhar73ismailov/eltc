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

    <%@include file="../jspf/pageNumberPanel.jspf" %>

    <form id="findFormId" action="show" method="post" accept-charset="utf-8" >
        <div id="findFormStyle" style="padding:10px 15px; background-color: #C9DCA6">   
            <input type="hidden" id="toFindFindId" name="toFind" value="1"/>
            <input type="hidden" id="entityFindId" name="entity" value="${entity}"/>
            <%-- <input type="hidden" id="pageFindId" name="page" value="${pageNumberPanel.currentNumber}"/> --%>
            <c:choose>
                <c:when test="${entity == 'student'}">
                    <input type="text" id="lastNameRuFindId" name="lastNameRu" placeholder="<fmt:message key='lastNameRu'/>" value="${findBean.lastNameRu}"/>
                    <input type="text" id="firstNameRuFindId" name="firstNameRu" placeholder="<fmt:message key='firstNameRu'/>"  value="${findBean.firstNameRu}"/>
                    <input type="text" id="commentsFindId" name="comments" placeholder="<fmt:message key='comments'/>"  value="${findBean.comments}"/>
                    <input type="text" id="emailFindId" name="email" placeholder="<fmt:message key='email'/>"  value="${findEmail}"/>
                    <input type="submit" value="<fmt:message key='find'/>"/>
                    <br/><span><fmt:message key='found'/>: ${findSize} </span> 
                    <span><a href="show?entity=${entity}"><fmt:message key='remove_the_filter'/></a></span> 
                    </c:when>
                    <c:when test="${entity == 'organization'}">
                    <input type="text" id="rnnFindId" name="rnn" placeholder="<fmt:message key='rnn'/>" value="${findBean.rnn}"/>
                    <input type="text" id="nameFindId" name="name" placeholder="<fmt:message key='name'/>"  value="${findBean.name}"/>
                    <input type="submit" value="<fmt:message key='find'/>"/>
                    <br><span><fmt:message key='found'/>: ${findSize} </span> 
                    <span><a href="show?entity=${entity}"><fmt:message key='remove_the_filter'/></a></span> 
                    </c:when>

            </c:choose>

        </div>
    </form>



    <c:choose>
        <c:when test="${dictionary == true}">
            <c:set var="pageTo" value="dic" scope="page"/>
        </c:when>
        <c:otherwise>
            <c:set var="pageTo" value="${entity}" scope="page"/> 
        </c:otherwise>
    </c:choose>
    <table border="1" class="contentfont">
        <tr>
            <td>№</td>
            <jsp:include page="/WEB-INF/listFragments/${pageTo}.jsp">
                <jsp:param name="beans" value="${beans}"/>
                <jsp:param name="pageNumber" value="${pageNumberPanel.currentNumber}"/>
                <jsp:param name="pageSize" value="${pageNumberPanel.recordsNumberForPage}"/>
            </jsp:include>
    </table>
    <%@include file="../jspf/pageNumberPanel.jspf" %>
</div>





