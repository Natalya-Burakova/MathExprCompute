<%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 19.07.18
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Answer </title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Info of repo:</h2>
        </div>
        <%
        if (request.getAttribute("json") != null) {
            out.println("<ul class=\"w3-ul\"> <li class=\\\"w3-hover-sand\\\">\"" + request.getAttribute("json") + "</li></ul>");
        }
        %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
