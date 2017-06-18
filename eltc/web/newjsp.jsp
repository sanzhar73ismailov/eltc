<%-- 
    Document   : newjsp
    Created on : May 5, 2013, 10:49:27 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <form name="ertret" action="">
            <input type="checkbox" name="ch"/><br>
            <input type="text" name="textInput" value="value default" disabled=""/><br>
            
            <select name="sel" disabled="disabled">
                <option value="1">one</option>
                <option value="2" selected="selected">two</option>
                <option value="3">three</option>
            </select>
            <br>
            <input type="submit" value="sadsa" name="asdsad" />
        </form>

        <%
            String par = "ch";
            if(request.getParameter(par) == null){
                out.print("null");
            }else if(request.getParameter(par).isEmpty()){
                out.print("empty");
            }else{
                out.print("not empty: " + request.getParameter(par));
            }
            out.print("<p>");
            par = "sel";
            if(request.getParameter(par) == null){
                out.print("sel=null");
            }else if(request.getParameter(par).isEmpty()){
                out.print("sel=empty");
            }else{
                out.print("sel not empty: " + request.getParameter(par));
            }
            
            out.print("<p>");
            par = "textInput";
            if(request.getParameter(par) == null){
                out.print("textInput=null");
            }else if(request.getParameter(par).isEmpty()){
                out.print("textInput=empty");
            }else{
                out.print("textInput not empty: " + request.getParameter(par));
            }
            
        %>
    </body>
</html>
