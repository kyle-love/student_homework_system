
<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.springMVC.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: 76382
  Date: 2020/3/8
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyTitle</title>
</head>
<body>
<table align="center" width = "960" border="1" bgcolor="white" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#f2ffbe" height="30">
        <td>学生学号</td>
        <td>学生姓名</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Student> list = (List<Student>) request.getAttribute("list");
        if( list == null || list.size() <= 0 ){
            System.out.println("none Data");
        }else{
            for(Student student : list){

    %>
    <tr align="center">
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>
        <td><%=student.getCreateTime()%></td>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
