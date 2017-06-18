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
    <h2>${requestScope.infoMessage}</h2>

    <table border="1">
        <tr>
            <td  valign="top"> Последние студенты
                <div id="student_summary"><table class="contentfont" border="0">
                        <c:forEach items="${students}" var="bean">
                            <tr>
                                <td>${bean.id}</td>
                                <td>${bean.lastNameRu}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
            <td valign="top"> Последние организации
                <div id="org_summary"><table class="contentfont" border="0">
                        <c:forEach items="${organizations}" var="bean">
                            <tr>
                                <td>${bean.id}</td>
                                <td>${bean.name}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
            <td valign="top"> Последние курсы
                <div id="timetable_summary"><table class="contentfont" border="0">
                        <c:forEach items="${timetables}" var="bean">
                            <tr>
                                <td>${bean.id}</td>
                                <td>

                                    ${bean.course.nameRu} ${bean.course.codeOwn}<br/>
                                    ${bean.trainerByTrainerOfficialId.lastNameRu} ${bean.trainerByTrainerOfficialId.firstNameRu}<br/>
                                    ${bean.auditory.name}
                                    <fmt:formatDate type="date" pattern="dd/MM/yyyy"  value="${bean.date}" />
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </td>
        </tr>
    </table>



</div>




