<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: macbooknatalya
  Date: 19.07.18
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info of repo</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-light-grey">
<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Info of repo: </h2>
        </div>
            <%
            ArrayList<String> properties = (ArrayList<String>) request.getAttribute("properties");
            String branch = "", rev = "";
            if (properties != null && !properties.isEmpty()) {
                out.println("<ul class=\"w3-ul\">");
                for (String s : properties) {
                    if (s.contains("{") || s.contains("}"));
                    else if (s.contains("git.branch"))
                        branch = s;
                    else if (s.contains("git.commit.id.abbrev"))
                        rev = s;
                    else
                        out.println("<li class=\"w3-hover-sand\" style=\"height: 4%\">" + s + "</li>");
                }
                out.println("</ul>");
                out.println("<div class=\"w3-container w3-red w3-opacity w3-left-align\">\n" + "<h2>"+ branch + "</h2></div>");
                out.println("<div class=\"w3-container w3-red w3-opacity w3-left-align\">\n" + "<h1>"+ rev + "</h1></div>");
            }
            %>
    </div>
</div>

<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>