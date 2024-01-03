<%@page import="java.util.*"%>
<%@page import="sumdu.edu.ua.mavenproject2.model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
            html{
                background-image: url('https://images.wallpaperscraft.ru/image/single/devushka_reka_zakat_1067581_1920x1080.jpg');
                background-size: cover;
                background-repeat: no-repeat;
            }
            h1{
            text-align:center;
            }
            #page{
            width:600px;
            margin:auto;
            padding: 20px;
            background-color: white;
            border-radius: 20px;
            margin-top: 50px;
            }
            form{
            width:400px;
            margin:20px auto;
            }
            input[type=submit]{
            margin:auto;
            }
            .list, .list td, .list th {
            margin:auto;
            border:1px solid black;
            border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    <div id="page">
    <h1>Student</h1>
    <form method="post" action="StudentAdd">
    <table>
    <tbody>
        <tr>
            <td><label for="name">Name</td>
            <td><input id="name" type="text" name="name"></td>
        </tr>
        <tr>
            <td><label for="surname">Surname</td>
            <td><input id="surname" type="text" name="surname"></td>
        </tr>
        <tr>
            <td><label for="age">Age</td>
            <td><input id="age" type="text" name="age"></td>
        </tr>
        <tr>
            <td><label for="email">Email</td>
            <td><input id="email" type="email" name="email"></td>
        </tr>
        <tr>
            <td><label for="group">Group</td>
            <td><input id="group" type="text" name="group"></td>
        </tr>
        <tr>
            <td><label for="faculty">Faculty</td>
            <td><input id="faculty" type="text" name="faculty"></td>
        </tr>
    </tbody>
    </table>
        <input type="submit" name="send" value="Send">
    </form>
    
    <c:if test="${students.size() > 0}">
        <table class="list">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Age</th>
                <th>Email</th>
                <th>Group</th>
                <th>Faculty</th>
                <th>Ref</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td><c:out value="${student.getId()}"/></td>
                    <td><c:out value="${student.getName()}"/></td>
                    <td><c:out value="${student.getSurname()}"/></td>
                    <td><c:out value="${student.getAge()}"/></td>
                    <td><c:out value="${student.getEmail()}"/></td>
                    <td><c:out value="${student.getGroup()}"/></td>
                    <td><c:out value="${student.getFaculty()}"/></td>
                    <td>
                        <a href="UserContent?id2=${student.getId()}">Marks</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </body>
</html>
