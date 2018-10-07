<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 15-Sep-18
  Time: 3:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html";charset=UTF-8>
</head>
<body>

<%
    String searchedId = request.getParameter("studentId");
    out.println(String.format("Student with id: <b>%s</b> counld not be found",searchedId));
%>
<br />
<button><a href="student.html">Back</a></button>

</body>
</html>
