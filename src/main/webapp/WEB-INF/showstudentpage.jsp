<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Customer Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        Her er en liste med alle studerende
        <table class ="table table-striped table-bordered table-hover">

            <tr>
                <th scope="col">ID</th>
                <th scope="col">Email</th>
                <th scope="col">Point</th>
            </tr>
            <c:forEach var="student" items="${requestScope.studentList}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.email}</td>
                    <td>${student.point}</td>
                </tr>

            </c:forEach>
        </table>
    </jsp:body>

</t:genericpage>

