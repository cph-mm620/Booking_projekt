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

        Role: ${sessionScope.role}
</br>
        Dine point: ${sessionScope.user.point}

        </br>

        <a href="${pageContext.request.contextPath}/fc/bookingpage">Book dit udstyr her:</a>

        </br>




    </jsp:body>

</t:genericpage>

