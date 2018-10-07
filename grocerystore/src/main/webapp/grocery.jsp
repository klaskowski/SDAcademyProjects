<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 01-Sep-18
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Date" %>
<%@ page import="ro.sda.logic.CartUtil" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" ;charset=UTF-8>
    <title>Display Groceries</title>
</head>
<body>


    <!--Table using taglib -->
    <%--<% List<String> result = (List<String>) request.getAttribute("selectedOption");--%>
    <%--Iterator<String> it = result.iterator();--%>
    <%--out.println("<br>We have <br><br>");--%>
    <%--while (it.hasNext()){--%>
        <%--out.println(it.next() + "<br>");--%>
    <%--}%>--%>
    <%--<br>--%>
        <%--<table>--%>
            <%--<tbody>--%>
                <%--<tr>--%>
                    <%--<th>Product</th>--%>
                <%--</tr>--%>
            <%--<c:forEach items="${requestScope.selectedOption}" var="grocery">--%>
                <%--<tr>--%>
                    <%--<td><c:out value="${grocery}"></c:out></td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        <%--</table>--%>


    <% List<String> groceryList = (List<String>) request.getAttribute("selectedOption"); %>
        <table border="1">
        <% for(String element:groceryList){ %>
            <tr>
                <td><% out.println(element);%></td>
                <td><button type="submit" onclick="<%CartUtil.addToCart(element); %>">Add to cart</button></td>
            </tr>
        <%}%>
        </table>

    <br>
    <button><a href="index.html">Back</a></button>
    <br>
    <% List<String> shoppingCart = (List<String>) request.getAttribute("addedProduct"); %>
    <button id="doneShopping" type="submit">Done shopping</button>


    <c:catch var="exception">
        <% int x=5/0; %>
    </c:catch>
    <c:if test="${exception ne null}">
        <p>Exception is: ${exception} <br>
        Exception Message: ${exception.message}</p>
    </c:if>

<%
    //Get session creation time
    Date createTime = new Date(session.getCreationTime());
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome back to my website";
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    String userIDKey = new String("userID");
    String userID = new String("ABCD");

    if(session.isNew()){
        title = "Welcome back to my website";
        session.setAttribute(userIDKey, userID);
        session.setAttribute(visitCountKey, visitCount);
    }
    visitCount = (Integer) session.getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    userID = (String) session.getAttribute(userIDKey);
    session.setAttribute(visitCountKey, visitCount);
%>

    <div style="text-align: center">
    <h1>Session Tracking</h1>
    </div>

    <table border="1" align="center">
        <tr bgcolor="#949494">
            <th>Session info</th>
            <th>Value</th>
        </tr>
        <tr>
            <td>id</td>
            <td><% out.print(session.getId()); %></td>
        </tr>
        <tr>
            <td>Creation Time</td>
            <td><% out.print(createTime); %></td>
        </tr>
        <tr>
            <td>Time of Last Access</td>
            <td><% out.print(lastAccessTime); %></td>
        </tr>
        <tr>
            <td>User ID</td>
            <td><% out.print(userID); %></td>
        </tr>
        <tr>
            <td>Number of visits</td>
            <td><% out.print(visitCount); %></td>
        </tr>
    </table>


</body>
</html>
