<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 01-Sep-18
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html";charset=UTF-8>
    <title>Login failed</title>
</head>
<body>
    <%
        String failedUser = (String) request.getAttribute("failedUser");
        out.println(String.format("Login failed (incorrect username, password or both) for user <b>%s</b>", failedUser));
    %>
    </body>
</html>
