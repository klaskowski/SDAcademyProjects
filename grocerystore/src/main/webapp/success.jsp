<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 01-Sep-18
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Directives -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html";charset=UTF-8>
    <title>Login Successful!</title>
</head>
<body>
    <!--Declaration-->
    <%! String congrats = "<i>Congratulations!</i>"; %>
    <%! String thanks = "Thank you!"; %>

    <br>

    <!-- Expressions -->
    Welcome & <%= congrats.toString() %>
    <br>

    <!-- Scriptlet -->
    <%
        String loggedUser = (String) request.getAttribute("loggedUser");
        out.println(String.format("Login Successful for user <b>%s</b>, %s", loggedUser, thanks));
    %>
    <br>
    <button><a href="/index.html">Groceries List</a></button>
</body>
</html>
