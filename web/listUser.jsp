<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2019/12/26
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <%
        String output = (String) request.getAttribute("UserList");
        PrintWriter out1 = response.getWriter();
        out1.print(output);
    %>
</body>
</html>
