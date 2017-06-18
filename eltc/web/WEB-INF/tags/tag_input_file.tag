<%@tag description="it's chunk for edit form where input file used" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@attribute name="filePrefixName" required="true" rtexprvalue="true"%>
<%@attribute name="fileProperty" required="true" rtexprvalue="true"%>

<%-- any content can be specified here e.g.: --%>


<tr>
    <td><label for="${filePrefixName}File"><fmt:message key='${filePrefixName}File'/></label></td>
<c:choose>
    <c:when test="${empty fileProperty}">
        <td id="${filePrefixName}FileBox">
            <input maxlength='40' id='${filePrefixName}File' type='file' name="${filePrefixName}File"/>
        </td>
    </c:when>
    <c:otherwise>
        <td id="${filePrefixName}FileBox">
            <div style="background-color: #CCEAFE">${fileProperty}</div>
            <input type='checkbox' 
                   onclick="confirmDelete();
                                           initDeleteFile('${filePrefixName}');
                                           deleteFile('${entity}', '${bean.id}');"/> 
            <input type='hidden' name="${filePrefixName}File" value='${fileProperty}'/>
        <fmt:message key='delete'/>
        </td>
    </c:otherwise>
</c:choose>
</tr>