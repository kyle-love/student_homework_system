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
    <title>添加作业</title>
</head>
<body><form action="addHomeworkServlet" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>作业id：</td>
            <td><input type="number" name="homework_id"/></td>
        </tr>

        <tr>
            <td>作业标题：</td>
            <td><input type="text" name="homework_title"/></td>
        </tr>

    </table><input type="submit" value="提交"/>

</form>
</body>
</html>
