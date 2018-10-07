<%--
  Created by IntelliJ IDEA.
  User: jitar
  Date: 02-Sep-18
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
</head>
<body>
<h1>You have these items in your cart:</h1>
<c:forEach items="${requestScope.cart}" var="cartItem">
    ${cartItem.key}  - ${cartItem.value}
    <br/>
</c:forEach>
<a href="<c:url value="/shop"><c:param name="action" value="browse" /></c:url>">Back to Browse</a>
<a href="<c:url value="/shop"><c:param name="action" value="empty" /></c:url>">Empty Cart</a>
</body>
</html>