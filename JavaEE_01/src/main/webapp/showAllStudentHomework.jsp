
<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.class01.model.StudentHomework" %><%--
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
            <td>ID</td>
            <td>学生学号</td>
            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
        </tr>
        <%
            List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");
            if( list == null || list.size() <= 0 ){
                out.println("none Data");
            }else{
                for(StudentHomework sh : list){

        %>
        <tr align="center">
            <td><%=sh.getId()%></td>
            <td><%=sh.getStudentId()%></td>
            <td><%=sh.getHomeworkId()%></td>
            <td><%=sh.getHomeworkTitle()%></td>
            <td><%=sh.getHomeworkContent()%></td>
            <td><%=sh.getCreateTime()%></td>
        </tr>
        <%

                }
            }
        %>
    </table>
</body>
</html>
