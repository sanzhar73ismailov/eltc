<%@ page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf">
    <jsp:param name="par1" value=""/>
    <jsp:param name="par2" value=""/>
</jsp:include>
<div id="container">
    <h1>${pageTitle}</h1>
    <div class="errorMessage">${requestScope.message}</div>
    
    <form name="login" action="toLogin" method="POST">
        <table>
            <tr>
                <td><fmt:message key="login"/></td><td><input type="text" name="login" value="${bean.login}" size="40" />
                    <div class='errorMessage'>${messageMap.login}</div>
                </td>
            </tr>
            <tr>
                <td><fmt:message key="password"/></td><td><input type="password" name="password" value="${bean.password}" size="40" />
                    <div class='errorMessage'>${messageMap.password}</div>
                </td>
            </tr>
            <tr>
                <td><input type='submit' name='submitButton'  class='buttonEditForm' value='<fmt:message key='OK'/>'/></td>
                <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td>
            </tr>
            <tr>
                <td><a href="registration"><fmt:message key="registration"/></a></td>
                <td></td>
            </tr>


        </table>
<input type="hidden" name="required" value="<%=""
                + "login:reqTrue:typeText^"
                + "password:reqTrue:typeText^"%>"/>
    </form>

</div>