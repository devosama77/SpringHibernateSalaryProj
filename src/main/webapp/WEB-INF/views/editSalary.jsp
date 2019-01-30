<%@ page import="java.util.List" %>
<%@ page import="org.osama.model.Salary" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ page import="org.osama.model.SalaryToEcxcel" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="srpring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 3/1/2018
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List  </title>
    <%
        ServletContext servletContext = getServletConfig().getServletContext();
      //  List<Salary> salaryList = (List<Salary>) servletContext.getAttribute("salaries");
        List<SalaryToEcxcel> listSalary=new ArrayList<>();

    %>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Terasek ... </h2>
    <security:authorize access="isAuthenticated()">
    <img src="/resources/images/logo.jpg"  class="img-circle"  alt="Terasek" width="200" height="140"/>
    </security:authorize>
<hr />
<h3>
    Welcome !
    <security:authorize access="isAnonymous()">
        Guest
    </security:authorize>
    <!-- Print the logged in user name -->
    <security:authorize access="isAuthenticated()">
        <security:authentication property="principal.username" />
    </security:authorize>
</h3>
<security:authorize access="isAnonymous()">
    Login as <a href="/user">User</a> or <a href="/admin">Admin</a>
</security:authorize>

<security:authorize access="isAuthenticated()">
    <security:authorize access="hasAnyRole('USER','ADMIN')">
<table class="table">
    <tr>
        <td><strong>Sequence</strong></td>
        <td><strong>Code Transfer</strong></td>
        <td><strong>Amount</strong></td>
        <td><strong>Full Name</strong></td>
        <td><strong>Bank SwiftCode</strong></td>
        <td><strong>Bank Number</strong></td>
        <td><strong>IC Number</strong></td>

    </tr>
    <% int i=0;%>
  <form action="download" method="post"  class="form-group">
    <c:forEach items="${salaries}" var="salary">
        <tr>
            <td>${salary.sequence}</td>
            <td>${salary.codeTransfer}</td>
            <td><input  name="<%="amount"+i++%>" class="form-control" required></input></td>
            <td>${salary.fullName}</td>
            <td>${salary.bankSwiftCode}</td>
            <td>${salary.bankNumber}</td>
            <td>${salary.icNumber}</td>
            <td> <spring:url value="/update/${salary.id}" var="updateUrl"></spring:url>
                <a href="${updateUrl}">Update</a></td>
            <td> <spring:url value="/delete/${salary.id}" var="deleteUrl"></spring:url>
                <a href="${deleteUrl}">Delete</a></td>
        </tr>
    </c:forEach>

</table>
<input type="submit" value="Download" class="form-control">


    <srpring:url value="/addSalary" var="add"></srpring:url>
    <a href="${add}" > <input type="button" value="New" class="form-control"></a>
    </form>

<%--<srping:url value="/download" var="xlsUrl"></srping:url>--%>
<%--<div class="list-group">--%>
    <%--<a href="${xlsUrl}" class="list-group-item" target="_blank">--%>
        <%--<h4 class="list-group-item-heading">Download</h4>--%>
    <%--</a>--%>
<%--</div>--%>
<br><br>
    <srping:url value="/logout" var="logout" ></srping:url><br>
    <a href="${logout}">Log Out </a>
    </security:authorize>
</security:authorize>
</div>
</div>
</body>
</html>
