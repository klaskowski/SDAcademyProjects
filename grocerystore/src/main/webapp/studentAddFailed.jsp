<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 12-Sep-18
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<html>
<head>
    <title>Add failed</title>
    <meta http-equiv="Content-Type" content="text/html";charset=UTF-8>
</head>
<body>
<b>Sorry</b>
<%
    String addedStudent = (String) request.getParameter("studentsFirstName") + request.getParameter("studentsLastName");
    out.println(String.format("Add failed for student <i>%s</i>", addedStudent));
%>
<br />
<button><a href="student.html">Back</a></button>

</body>
</html>
