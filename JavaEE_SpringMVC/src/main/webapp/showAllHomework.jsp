
<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.springMVC.model.Homework" %><%--
  Created by IntelliJ IDEA.
  User: 76382
  Date: 2020/3/8
  Time: 20:02
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
        <td>作业ID</td>
        <td>作业标题</td>
        <td>创建时间</td>
    </tr>
    <%
        List<Homework> list = (List<Homework>) request.getAttribute("list");
        if( list == null || list.size() <= 0 ){
            out.println("none Data");
        }else{
            for(Homework homework : list){

    %>
    <tr align="center">
        <td><%=homework.getId()%></td>
        <td><%=homework.getHomeworkTitle()%></td>
        <td><%=homework.getCreateTime()%></td>
    </tr>
    <%

            }
        }
    %>
</table>
</body>
</html>
