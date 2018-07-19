<%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 18.07.18
  Time: 1:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Start app!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h1>Start app!</h1>
</div>

<div class="w3-container w3-center">
    <div class="w3-bar w3-padding-large w3-padding-24">
        <label>
            <input type="text" value="Choose an action:" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 100%"><br />
        </label>
        <button type="submit" class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/math'">compute expression</button>
        <button class="w3-btn w3-hover-green w3-round-large" onclick="location.href='/info'" type="submit">info of repo</button>
    </div>
</div>
</body>
</html>
