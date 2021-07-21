<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a Admin of our wonderful site.

        <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Antal dage</th>
            <th scope="col">Dato</th>
            <th scope="col">Status</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="booking" items="${requestScope.bookingList}">
            <tr>
                <td>${booking.days}</td>
                <td>${booking.booking_date}</td>
                <td>${booking.booking_status}</td>
            </tr>

        </c:forEach>

    </jsp:body>
</t:genericpage>
