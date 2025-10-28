<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获取参数
    String num1Str = request.getParameter("num1");
    String num2Str = request.getParameter("num2");
    String operator = request.getParameter("operator");
    String result = "";
    String error = "";
    // 验证参数是否为空
    if (num1Str != null && num2Str != null && operator != null) {
        try {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double calcResult = 0;

            // 进行计算
            switch (operator) {
                case "+":
                    calcResult = num1 + num2;
                    break;
                case "-":
                    calcResult = num1 - num2;
                    break;
                case "*":
                    calcResult = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        error = "除数不能为0";
                    } else {
                        calcResult = num1 / num2;
                    }
                    break;
            }

            if (error.isEmpty()) {
                result = String.valueOf(calcResult);
            } else {
                result = error;
            }

        } catch (NumberFormatException e) {
            result = "请输入有效的数字";
        }
    }
    // 将结果放入request域中
    request.setAttribute("result", result);
%>

<html>
<head>
    <title>简易计算器</title>
</head>
<body>
<h2>我的计算器</h2>
<form method="post">
    第一个参数：<input type="text" name="num1" value="${param.num1}"><br>
    运算类型：
    <select name="operator">
        <option value="+" ${param.operator == '+' ? 'selected' : ''}>+</option>
        <option value="-" ${param.operator == '-' ? 'selected' : ''}>-</option>
        <option value="*" ${param.operator == '*' ? 'selected' : ''}>*</option>
        <option value="/" ${param.operator == '/' ? 'selected' : ''}>/</option>
    </select><br>
    第二个参数：<input type="text" name="num2" value="${param.num2}"><br>
    <input type="submit" value="计算">
    <input type="button" value="重置" onclick="window.location.href='calculator.jsp'">
    结果：<input type="text" name="result" value="${result}" readonly>
</form>
</body>
</html>