<%@page import="eltc.web.Registration"%>
<%@page import="eltc.web.ServletUtilMethods"%>
<%@ page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf">
    <jsp:param name="par1" value=""/>
    <jsp:param name="par2" value=""/>
</jsp:include>
<div id="container">
    <h1><%
        if (eltc.util.Configurator.isTestMode()) {
            Registration registration = (Registration) ServletUtilMethods.createRegistration();
            pageContext.setAttribute("registration", registration);
        }

        %>
    </h1>


    <%


    %>

        

            <div class="errorMessage">${requestScope.message}</div>


            <form name="login" action="toRegistry" method="POST">
                <input type="hidden" name="entity" value="registration">
                <table>

                    <tr>
                        <td><fmt:message key="nameJust"/></td><td><input type="text" name="name" value="${bean.name}" size="40" />
                            <div class='errorMessage'>${messageMap.name}</div></td></tr>
                    </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="login"/></td><td><input type="text" name="login" value="${bean.login}" size="40" />
                            <div class='errorMessage'>${messageMap.login}</div></td></tr>
                    </td>
                    </tr>

                    <tr>
                        <td><fmt:message key="email"/></td><td><input type="text" name="email1" value="${bean.email1}" size="40" />
                            <div class='errorMessage'>${messageMap.email1}</div></td></tr>
                    </td>
                    </tr>

                    <tr>
                        <td><fmt:message key="emailAgain"/></td><td><input type="text" name="email2" value="${bean.email2}" size="40" />
                            <div class='errorMessage'>${messageMap.email2}</div></td></tr>
                    </td>
                    </tr>


                    <tr>
                        <td><fmt:message key="password"/> (<fmt:message key="password_must_be_not_less_6"/>)</td><td><input type="password" name="password1" value="${bean.password1}" size="40" />
                            <div class='errorMessage'>${messageMap.password1}</div></td></tr>
                    </td>
                    </tr>
                    <tr>
                        <td><fmt:message key="passwordAgain"/></td><td><input type="password" name="password2" value="${bean.password2}" size="40" />
                            <div class='errorMessage'>${messageMap.password2}</div></td></tr>
                    </td>
                    </tr>

                    <tr>
                        <td><fmt:message key="password"/> общий (спросить у админа)</td><td><input type="password" name="passwordGeneral" value="${bean.passwordGeneral}" size="40" />
                            <div class='errorMessage'>${messageMap.passwordGeneral}</div></td></tr>
                    </td>
                    </tr>

                    <tr>
                        <td><input type='submit' name='submitButton' class='buttonEditForm' value='<fmt:message key='OK'/>'/></td>
                        <td><input type='reset'  class='buttonEditForm' value='<fmt:message key='reset'/>'/></td>
                    </tr>


                </table>
                <input type="hidden" name="required" value="<%="name:reqTrue:typeText^"
                        + "login:reqTrue:typeText^"
                        + "email1:reqTrue:typeText^"
                        + "email2:reqTrue:typeText^"
                        + "password1:reqTrue:typeText^"
                        + "password2:reqTrue:typeText^"
                        + "passwordGeneral:reqTrue:typeText"%>"/>
            </form>

</div>