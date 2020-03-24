<%--
  Created by IntelliJ IDEA.
  User: 76382
  Date: 2020/3/8
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>添加学生</title>
</head>
<body><form action="addStudentServlet" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>学生学号：</td>
            <td><input type="number" name="id"/></td>
        </tr>

        <tr>
            <td>学生姓名：</td>
            <td><input type="text" name="name"/></td>
        </tr>

    </table><input type="submit" value="提交"/>

</form>
</body>
</html>
