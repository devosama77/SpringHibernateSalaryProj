<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/1/2018
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<security:authorize access="isAuthenticated()">
<srping:url value="/downloadPage?type=xlsx" var="xlsUrl" ></srping:url>

<div class="list-group">
    <a href="${xlsUrl}" class="list-group-item" target="_blank">
        <h4 class="list-group-item-heading">Excel Download</h4>
    </a>
</div>
</security:authorize>
</body>
</html>
