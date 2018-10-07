<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 12-Sep-18
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Display searched results</title>
    <meta http-equiv="Content-Type" content="text/html";charset=UTF-8>
</head>
<body>

<%
    String searchedStudent = (String) request.getParameter("studentId") + ":" + request.getParameter("studentsFirstName") + ", " + request.getParameter("studentsLastName");
    out.println(String.format("You searched for: <i>%s</i>", searchedStudent));
%>
<br />
<button><a href="student.html">Back</a></button>
</body>
</html>
