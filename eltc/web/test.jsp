<%-- 
    Document   : test
    Created on : Jul 5, 2013, 3:07:02 PM
    Author     : sanzhar.ismailov
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Page (/test.jsp)!</h1>

        <script>
            function mySubmit(objectSt) {
                var form = document.getElementById("myForm");
//                var input = document.createElement('input');
//                input.name = 'nName';
//                input.value = 'qqqqqqqqq';
//                input.type = 'text';
//                form.appendChild(input);
//                document.getElementById("nameId").value = objectSt.name;
//                document.getElementById("ageId").value = objectSt.age;
                form.submit();

            }

            function submitform()
            {
                document.myformsearch.submit();
            }

        </script>
    </head>
    <form id="myForm" name='myformName' method="get" action="test">
        <input type="text" id="nameId" name="name" value="George"/><br>
        <input type="text" id="ageId" name="age" value="12"/><br>
        <input type="submit" name="submit1" value="Go"/><br>
    </form>


    <form id="myFormBoolean" name='myformNameBoolean' method="get" action="test">
        <input type="checkbox" name="check1" value="George"/><br>
        <input type="submit" name="submit1" value="Go"/><br>
    </form>


    <a href="javascript: mySubmit({name: 'Vladimir', age: 12})">Vladimir, 12</a><br>
    <a href="javascript: mySubmit({name: 'Friend', age: 34})">Friend', 34</a><br>
    <a href="javascript: mySubmit({name: 'FriendNull', age: ''})">Friend', 34</a><br>


    <c:if test="${myBoolean == true}">
        myBoolean == true
    </c:if>
    <p/>

    <c:if test="${myBoolean == null}">
        myBoolean == null
    </c:if>
    <p/>

    <c:if test="${empty myBoolean}">
        myBoolean == empty
    </c:if>

    <c:if test="${not empty myBoolean}">
        myBoolean == not empty
    </c:if>    


    <form id="myForm" name='myformName' method="get" action="">
        <input type="text" id="nameId" name="name" value="George"/><br>
        <input type="text" id="ageId" name="age" value="12"/><br>
        <input type="submit" name="submit1" value="Go"/><br>
    </form>
    <b>
        ${name}<br/>
        ${age}<br/>
    </b>

</body>
</html>
