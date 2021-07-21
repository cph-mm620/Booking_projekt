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


        <h5>dage:</h5>
        <p>
                ${requestScope.booking.days}
        </p>
        <h5>dato:</h5>
        <p>
            ${requestScope.booking.booking_date}
        </p>
        <h5>status:</h5>
        <p>
                ${requestScope.booking.booking_status = "Reseveret"}
        </p>

    </jsp:body>

</t:genericpage>

