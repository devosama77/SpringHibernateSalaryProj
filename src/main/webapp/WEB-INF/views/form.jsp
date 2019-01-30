<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/1/2018
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save or Update</title>
    <style>
        .error
        {
            color: red;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        function changSwiftCode(obj) {
            var v=obj.value;
            var parent=document.getElementById("swiftCode");
            if(v=="AMISLAMIC BANK BERHAD"){
                parent.setAttribute("value","AISLMYKL");
                parent.innerHTML="AISLMYKL";
            }
            else if(v=="ASIAN FINANCE BANK BERHAD"){
                parent.setAttribute("value","AFBQMYKL");
                parent.innerHTML="AFBQMYKL";
            }
            else if(v=="BANGKOK BANK BERHAD"){
                parent.setAttribute("value","BKKBMYKL");
                parent.innerHTML="BKKBMYKL";
            }

//            .............................


//            17	BANK ISLAM MALAYSIA BERHAD	KUALA LUMPUR		BIMBMYKL
//            19	BANK KERJASAMA RAKYAT MALAYSIA BERHAD (BANK RAKYAT)	KUALA LUMPUR		BKRMMYKL
//            21	BANK MUAMALAT MALAYSIA BERHAD (6175-W)	KUALA LUMPUR		BMMBMYKL
        else if(v=="BANK ISLAM MALAYSIA BERHAD"){
                parent.setAttribute("value","BIMBMYKL");
                parent.innerHTML="BIMBMYKL";
            }
            else if(v=="BANK KERJASAMA RAKYAT MALAYSIA BERHAD (BANK RAKYAT)"){
                parent.setAttribute("value","BKRMMYKL");
                parent.innerHTML="BKRMMYKL";
            }
            else if(v=="BANK MUAMALAT MALAYSIA BERHAD (6175-W)"){
                parent.setAttribute("value","BMMBMYKL");
                parent.innerHTML="BMMBMYKL";
            }
//            .......................
//            28	BANK OF CHINA (MALAYSIA) BERHAD	KUALA LUMPUR		BKCHMYKL
//            32	BANK PERTANIAN MALAYSIA BERHAD-AGROBANK	KUALA LUMPUR		AGOBMYKL
//            35	BNP PARIBAS MALAYSIA BERHAD	KUALA LUMPUR		BNPAMYKL
            else if(v=="BANK OF CHINA (MALAYSIA) BERHAD"){
                parent.setAttribute("value","BKCHMYKL");
                parent.innerHTML="BKCHMYKL";
            }
            else if(v=="BANK PERTANIAN MALAYSIA BERHAD-AGROBANK"){
                parent.setAttribute("value","AGOBMYKL");
                parent.innerHTML="AGOBMYKL";
            }
            else if(v=="BNP PARIBAS MALAYSIA BERHAD"){
                parent.setAttribute("value","BNPAMYKL");
                parent.innerHTML="BNPAMYKL";
            }
//            ............................
//            37	CHINA CONSTRUCTION BANK (MALAYSIA) BERHAD	KUALA LUMPUR		PCBCMYKL
//            40	CIMB BANK BERHAD	KUALA LUMPUR		CIBBMYKL
//            42	CIMB INVESTMENT BANK BERHAD	KUALA LUMPUR		COIMMYKL
            else if(v=="CHINA CONSTRUCTION BANK (MALAYSIA) BERHAD"){
                parent.setAttribute("value","PCBCMYKL");
                parent.innerHTML="PCBCMYKL";
            }
            else if(v=="CIMB BANK BERHAD\tKUALA LUMPUR"){
                parent.setAttribute("value","CIBBMYKL");
                parent.innerHTML="CIBBMYKL";
            }
            else if(v=="CIMB INVESTMENT BANK BERHAD"){
                parent.setAttribute("value","COIMMYKL");
                parent.innerHTML="COIMMYKL";
            }
//          .......................

//            43	CIMB ISLAMIC BANK BERHAD	KUALA LUMPUR		CTBBMYKL
//            44	CIMB-PRINCIPAL ASSET MANAGEMENT BERHAD	KUALA LUMPUR		CANHMYKL
//            47	CITIBANK BERHAD	KUALA LUMPUR	(JALAN AMPANG)	CITIMYKL

        else if(v=="CIMB ISLAMIC BANK BERHAD"){
                parent.setAttribute("value","CTBBMYKL");
                parent.innerHTML="CTBBMYKL";
            }
            else if(v=="CIMB-PRINCIPAL ASSET MANAGEMENT BERHAD"){
                parent.setAttribute("value","CANHMYKL");
                parent.innerHTML="CANHMYKL";
            }
            else if(v=="CITIBANK BERHAD"){
                parent.setAttribute("value","CITIMYKL");
                parent.innerHTML="CITIMYKL";
            }
        }
    </script>
</head>
<body>
<security:authorize access="isAuthenticated()">
<div class="container">
<h1>Input Form</h1>
<spring:url value="/saveUpdateSalary" var="save"></spring:url>

<form:form action="${save}" method="post" modelAttribute="salary" class="form-group" >
    <table>
        <tr><td><form:hidden path="id" ></form:hidden></td></tr>
        <tr>
            <td>Sequence</td>
            <td>
                <form:input path="sequence" type="number" required="required" class="form-control" /> <br />
                <form:errors path="sequence" cssClass="error"  />
            </td>
        </tr>
        <tr>
            <td>Code Transfer</td>
            <td>
                <form:select path="codeTransfer" itemValue="30" class="form-control">
                    <form:option value="30"></form:option>
                    <form:option value="10"></form:option>
                </form:select>

            </td>
        </tr>

        <tr>
            <td>Full Name</td>
            <td>
                <form:input path="fullName" required="required" class="form-control" />
                <form:errors path="fullName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Bank Name</td>
            <td>
                <form:select path="bankName"  onchange="changSwiftCode(this)" class="form-control" >
                    <form:options items="${salary.linkedHashMapBankName}"></form:options>
                </form:select>

                <form:errors path="bankName" cssClass="error" />
            </td>
        </tr>
        <tr>
            <td>Bank Swift Code</td>
            <td>
                <form:input path="bankSwiftCode" id="swiftCode"  required="required" class="form-control"/>

            </td>
        </tr>

        <tr>
            <td>Bank Number</td>
            <td>
                <form:input  path="bankNumber" type="number" required="required" class="form-control"/> <br />
                <form:errors path="bankNumber" cssClass="error" />
            </td>
        </tr>

        <tr>
            <td>IC Number</td>
            <td>
                <form:input type="number" path="icNumber" required="required" class="form-control" /> <br />
                <form:errors path="icNumber" cssClass="error"  />
            </td>
        </tr>
        <tr>
            <td colspan="2"><button type="submit" class="form-control">save</button></td>
        </tr>
    </table>

</form:form>
</div>
</security:authorize>
</body>
</html>
