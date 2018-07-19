<%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 18.07.18
  Time: 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Compare expression</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Input expression:</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <textarea type="text" name="expr" class="w3-textarea w3-white" cols="40" rows="10"> </textarea>
        <button type="submit" formmethod="post" class="w3-btn w3-green w3-round-large w3-margin-bottom" onclick="location.href='/compute'">compute</button>
    </form>
</div>
</body>
</html>