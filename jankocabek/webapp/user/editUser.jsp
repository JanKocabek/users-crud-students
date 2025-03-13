<%--
  Created by IntelliJ IDEA.
  User: sehes
  Date: 3/12/2025
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/user/update" var="actionUrl"/>
<p>Form will submit to: ${actionUrl}</p>  <%-- Debugging Line --%>
<form method="POST" action="${actionUrl}">
    <fieldset>
        <legend>User</legend>
        <label>Username:
            <input type="text" name="username" value="${user.userName}"/></label>
        <label> email:
            <input type="email" name="email" value="${user.email}"/>
        </label>
        <label>Password:
            <input type="password" name="password" value=""/>
        </label>
        <input type="submit" value="Submit"/>
    </fieldset>
</form>
</body>
</html>
