<%@page pageEncoding="UTF-8" %>

<jsp:include page="/WEB-INF/jspf/lefter.jspf"/>

<div id="container">
    <h1>${pageTitle}</h1>

    <c:if test="${not empty requestScope.message}">
        <div class="errorMessage">${requestScope.message}</div>
    </c:if> 



    <form id='Organization' method='post' name='Organization' action='save' charset='utf-8'>
        <input type='hidden' name='entity' value="${entity}">
        <input type='hidden' name='pageTitle' value="${pageTitle}">
        <input id='id' type='hidden' name='id' value='${bean.id}'>
        <table>
            <c:if test="${bean.id != null}"><tr><td><fmt:message key='id'/></td><td>${bean.id}</td></tr></c:if>
            
            <tr><td><label for='name'><fmt:message key='name'/></label></td>
                <td><input required='required' class='inpReq' maxlength='254' id='name' type='text' name='name' size='40' value='${bean.name}'/>
                    <div class='errorMessage'>${messageMap.name}</div></td></tr>

            <tr><td><label for='nameEn'><fmt:message key='nameEn'/></label></td>
                <td><input maxlength='254' id='nameEn' type='text' name='nameEn' size='40' value='${bean.nameEn}'/>
                    <div class='errorMessage'>${messageMap.nameEn}</div></td></tr>

            <tr><td><label for='vendor'><fmt:message key='vendor'/></label></td>
                <td>
                    <select name='vendor' id='vendor'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${vendors}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.vendor.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.vendor}</div>
                </td></tr>


            <tr><td><label for='industry'><fmt:message key='industry'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='industry' id='industry'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${industries}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.industry.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.industry}</div>
                </td></tr>

            <tr><td><label for='typeOwnership'><fmt:message key='typeOwnership'/></label></td>
                <td>
                    <select required='required' class='inpReq' name='typeOwnership' id='typeOwnership'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${typeOwnerships}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.typeOwnership.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.typeOwnership}</div>
                </td></tr>

            <tr><td><label for='region'><fmt:message key='region'/></label></td>
                <td>
                    <select name='region' id='region'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${regions}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.region.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.region}</div>
                </td></tr>

            <tr><td><label for='locality'><fmt:message key='locality'/></label></td>
                <td><input maxlength='100' id='locality' type='text' name='locality' size='40' value='${bean.locality}'/>
                    <div class='errorMessage'>${messageMap.locality}</div></td></tr>

            <tr><td><label for='cityByCityOfficialId'><fmt:message key='cityByCityOfficialId'/></label></td>
                <td>
                    <select name='cityByCityOfficialId' id='cityByCityOfficialId' onchange="setTheSameInSelect(this.id, 'cityByCityFactId');">
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${cities}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.cityByCityOfficialId.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.cityByCityOfficialId}</div>
                </td></tr>

            <tr><td><label for='streetHouseOfficial'><fmt:message key='streetHouseOfficial'/></label></td>
                <td><input maxlength='100' id='streetHouseOfficial' type='text' name='locality' size='40' value='${bean.streetHouseOfficial}' onchange="setTheSameInInput(this.id, 'streetHouseFact');"/>
                    <div class='errorMessage'>${messageMap.streetHouseOfficial}</div></td></tr>


            <tr><td><label for='postalCodeOfficial'><fmt:message key='postalCodeOfficial'/></label></td>
                <td><input maxlength='20' id='postalCodeOfficial' type='text' name='postalCodeOfficial' size='40' value='${bean.postalCodeOfficial}' onchange="setTheSameInInput(this.id, 'postalCodeFact');"/>
                    <div class='errorMessage'>${messageMap.postalCodeOfficial}</div></td></tr>

            <tr><td><label for='cityByCityFactId'><fmt:message key='cityByCityFactId'/></label></td>
                <td>
                    <select name='cityByCityFactId' id='cityByCityFactId'>
                        <option value=''><fmt:message key='not_selected'/></option>
                        <c:forEach items='${cities}' var='item'>
                            <option value='${item.id}' <c:if test='${item.id==bean.cityByCityFactId.id}'>selected='selected'</c:if> >${item.name}</option>
                        </c:forEach>
                    </select>
                    <div class='errorMessage'>${messageMap.cityByCityFactId}</div>
                </td></tr>


            <tr><td><label for='streetHouseFact'><fmt:message key='streetHouseFact'/></label></td>
                <td><input maxlength='100' id='streetHouseFact' type='text' name='houseFact' size='40' value='${bean.streetHouseFact}'/>
                    <div class='errorMessage'>${messageMap.streetHouseFact}</div></td></tr>

            <tr><td><label for='postalCodeFact'><fmt:message key='postalCodeFact'/></label></td>
                <td><input maxlength='20' id='postalCodeFact' type='text' name='postalCodeFact' size='40' value='${bean.postalCodeFact}'/>
                    <div class='errorMessage'>${messageMap.postalCodeFact}</div></td></tr>

            <tr><td><label for='fax'><fmt:message key='fax'/></label></td>
                <td><input maxlength='40' id='fax' type='text' name='fax' size='40' value='${bean.fax}'/>
                    <div class='errorMessage'>${messageMap.fax}</div></td></tr>
            <tr><td><label for='internetSite'><fmt:message key='internetSite'/></label></td>
                <td><input maxlength='40' id='internetSite' type='text' name='internetSite' size='40' value='${bean.internetSite}'/>
                    <div class='errorMessage'>${messageMap.internetSite}</div></td></tr>
            <tr><td><label for='email'><fmt:message key='email'/></label></td>
                <td><input maxlength='40' id='email' type='email' name='email' size='40' value='${bean.email}'/>
                    <div class='errorMessage'>${messageMap.email}</div></td></tr>
            <tr><td><label for='rnn'><fmt:message key='rnn'/></label></td>
                <td><input  required='required' class='inpReq' maxlength='40' id='rnn' type='text' name='rnn' size='40' value='${bean.rnn}'/>
                    <div class='errorMessage'>${messageMap.rnn}</div></td></tr>
            <tr><td><label for='bin'><fmt:message key='bin'/></label></td>
                <td><input maxlength='40' id='bin' type='text' name='bin' size='40' value='${bean.bin}'/>
                    <div class='errorMessage'>${messageMap.bin}</div></td></tr>
            <tr><td><label for='kbe'><fmt:message key='kbe'/></label></td>
                <td><input maxlength='40' id='kbe' type='text' name='kbe' size='40' value='${bean.kbe}'/>
                    <div class='errorMessage'>${messageMap.kbe}</div></td></tr>
            <tr><td><label for='bankName'><fmt:message key='bankName'/></label></td>
                <td><input maxlength='40' id='bankName' type='text' name='bankName' size='40' value='${bean.bankName}'/>
                    <div class='errorMessage'>${messageMap.bankName}</div></td></tr>
            <tr><td><label for='bankAddress'><fmt:message key='bankAddress'/></label></td>
                <td><input maxlength='100' id='bankAddress' type='text' name='bankAddress' size='40' value='${bean.bankAddress}'/>
                    <div class='errorMessage'>${messageMap.bankAddress}</div></td></tr>
            <tr><td><label for='bic'><fmt:message key='bic'/></label></td>
                <td><input maxlength='50' id='bic' type='text' name='bic' size='40' value='${bean.bic}'/>
                    <div class='errorMessage'>${messageMap.bic}</div></td></tr>
            <tr><td><label for='accountTg'><fmt:message key='accountTg'/></label></td>
                <td><input maxlength='40' id='accountTg' type='text' name='accountTg' size='40' value='${bean.accountTg}'/>
                    <div class='errorMessage'>${messageMap.accountTg}</div></td></tr>
            <tr><td><label for='accountDollar'><fmt:message key='accountDollar'/></label></td>
                <td><input maxlength='40' id='accountDollar' type='text' name='accountDollar' size='40' value='${bean.accountDollar}'/>
                    <div class='errorMessage'>${messageMap.accountDollar}</div></td></tr>
            <tr><td><label for='accountRuble'><fmt:message key='accountRuble'/></label></td>
                <td><input maxlength='40' id='accountRuble' type='text' name='accountRuble' size='40' value='${bean.accountRuble}'/>
                    <div class='errorMessage'>${messageMap.accountRuble}</div></td></tr>
            <tr><td><label for='accountEuro'><fmt:message key='accountEuro'/></label></td>
                <td><input maxlength='40' id='accountEuro' type='text' name='accountEuro' size='40' value='${bean.accountEuro}'/>
                    <div class='errorMessage'>${messageMap.accountEuro}</div></td></tr>
            <tr><td><input type='submit' name='submitButton' class='buttonEditForm' value='Сохранить'/></td>
                <td><input type='reset'class='buttonEditForm' value='Очистить'/></td></tr>
        </table>
        <input type='hidden' name='required' value='<%="industry:reqTrue:typeDic^"
                + "typeOwnership:reqTrue:typeDic^"
                + "vendor:reqFalse:typeDic^"
                + "region:reqFalse:typeDic^"
                + "locality:reqFalse:typeText^"
                + "name:reqTrue:typeText^"
                + "nameEn:reqFalse:typeText^"
                + "streetHouseOfficial:reqFalse:typeText^"
                + "postalCodeOfficial:reqFalse:typeText^"
                + "streetHouseFact:reqFalse:typeText^"
                + "postalCodeFact:reqFalse:typeText^"
                + "fax:reqFalse:typeText^"
                + "internetSite:reqFalse:typeText^"
                + "email:reqFalse:typeEmail^"
                + "rnn:reqTrue:typeText^"
                + "bin:reqFalse:typeText^"
                + "kbe:reqFalse:typeText^"
                + "bankName:reqFalse:typeText^"
                + "bankAddress:reqFalse:typeText^"
                + "bic:reqFalse:typeText^"
                + "accountTg:reqFalse:typeText^"
                + "accountDollar:reqFalse:typeText^"
                + "accountRuble:reqFalse:typeText^"
                + "accountEuro:reqFalse:typeText"%>'/>
    </form>



</div>





