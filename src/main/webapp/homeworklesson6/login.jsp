<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 设置字符编码
    request.setCharacterEncoding("UTF-8");

    String inputUsername = request.getParameter("username");
    String inputPassword = request.getParameter("password");

    if(inputUsername != null && inputPassword != null) {
        if("孤独求败".equals(inputUsername) && "123456".equals(inputPassword)) {
            session.setAttribute("username", inputUsername);
            session.setAttribute("password", inputPassword);
            response.sendRedirect("display.jsp");
            return;
        } else {
            out.print("<p>用户名或密码错误！用户名=孤独求败，密码=123456</p>");
        }
    }
%>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<h2>用户登录</h2>
<form method="post">
    用户名: <input type="text" name="username"><br>
    密码: <input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>