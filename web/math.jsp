<%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 18.07.18
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/compute" method="post">
  <p>Enter an arithmetic expression in JSON format:</p>
  <p><textarea name="expr" required></textarea></p>
  <p><input name="сompute" type="submit" value="compute"></p>
</form>
</body>
</html>