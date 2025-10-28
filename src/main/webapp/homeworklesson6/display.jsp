<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示用户信息</title>
</head>
<body>
<h2>用户信息</h2>
<%
    // 从session中获取用户名和密码
    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");

    // 检查数据是否存在
    if (username != null && password != null) {
%>
<p>用户名：<%= username %></p>
<p>密码：<%= password %></p>
<%
} else {
%>
<p>未找到用户信息</p>
<%
    }
%>
</body>
</html>