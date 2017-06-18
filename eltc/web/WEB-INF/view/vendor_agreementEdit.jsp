<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if>  



        <form id='VendorAgreement' method='post' name='VendorAgreement' action='save' charset='utf-8' enctype="multipart/form-data">
        <input type='hidden' name='entity' value='${param.entity}'>
        <input type='hidden' name='pageTitle' value='${pageTitle}'>
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            <tr><td><label for='vendor'><fmt:message key='vendor'/></label></td>
                <td>
                    <select  required='required' class='inpReq' name='vendor' id='vendor'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${vendors}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.vendor.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.vendor}</div>
                </td></tr>
            <tr><td><label for='number'><fmt:message key='number'/></label></td>
                <td><input required='required' class='inpReq' maxlength='40' id='number' type='text' name='number' size='40' value='${bean.number}'/>
                    <div class='errorMessage'>${messageMap.number}</div></td></tr>
            <tr><td><label for='date'><fmt:message key='date'/></label></td>
                <td><input required='required' class='inpReq' id='date' type='text' name='date' size='40' onblur="IsObjDate(this);" onkeyup="TempDt(event, this);" value='<fmt:formatDate pattern="dd/MM/yyyy" value="${bean.date}"/>'/>
                    <div class='errorMessage'>${messageMap.date}</div></td></tr>
            <tr><td><label for='description'><fmt:message key='description'/></label></td>
                <td><input maxlength='40' id='description' type='text' name='description' size='40' value='${bean.description}'/>
                    <div class='errorMessage'>${messageMap.description}</div></td></tr>


            <myTag:tag_input_file filePrefixName="pdf"  fileProperty="${bean.pdfFile}"/>

            
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='<fmt:message key='save'/>' onclick="return checkFileSize({pdfFile: 15});"/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="vendor:reqTrue:typeDic^"
                + "number:reqTrue:typeText^"
                + "date:reqTrue:typeDate^"
                + "description:reqFalse:typeText^"
                + "pdfFile:reqFalse:typeText"%>'/>
    </form>



</div>





