<%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 19.07.18
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<p>Answer: </p>
<div>
    <%
        if (request.getAttribute("json") != null) {
            out.println(request.getAttribute("json") + "\n");
        }
    %>

</div>

<div>
    <button onclick="location.href='/'">Back to start</button>
</div>
</body>
</html>
