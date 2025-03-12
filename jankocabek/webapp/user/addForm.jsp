<%--
  Created by IntelliJ IDEA.
  User: sehes
  Date: 3/12/2025
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<h1>Add User</h1>
<c:url value="/user/add" var="actionUrl"/>
<form method="POST" action="${actionUrl}">
    <fieldset>
        <legend>User Details</legend>
        <label >Username:
            <input type="text" name="username">
        </label>
        <label>Email:
            <input type="email" name="email">
        </label>
        <label>Password:
            <input type="password" name="password">
        </label>
        <button type="submit">SUBMIT</button>
    </fieldset>
</form>
</body>
</html>
