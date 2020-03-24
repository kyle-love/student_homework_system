<%@ page import="java.util.List" %>
<%@ page import="org.example.javaee.class01.model.Homework" %>
Created by IntelliJ IDEA.
  User: 76382
  Date: 2020/3/9
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>提交作业</title>
</head>
<body><form action="addStudentHomeworkServlet" method="post">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>提交编号id：</td>
            <td><input type="number" name="sh_id"/></td>
        </tr>

        <tr>
            <td>学生id：</td>
            <td><input type="number" name="student_id"/></td>
        </tr>

        <tr>
            <td>作业id：</td>
            <td><input type="number" name="homework_id"/></td>
        </tr>



        提交的作业标题
        <select name="homework_title" >
            <%
                List<Homework> list = (List<Homework>) request.getAttribute("list");
                if( list == null || list.size() <= 0 ){
                    out.println("none Data");
                }else{
                    for(Homework homework : list){

            %>
            <option ><%=homework.getHomeworkTitle()%></option>
            <%

                    }
                }
            %>
        </select>

<%--        <tr>--%>
<%--            <td>作业标题：</td>--%>
<%--            <td><input type="text" name="homework_title"/></td>--%>
<%--        </tr>--%>

        <tr>
            <td>作业内容：</td>
            <td><input type="text" name="homework_content"/></td>
        </tr>

    </table><input type="submit" value="提交"/>


</form>
</body>
</html>
