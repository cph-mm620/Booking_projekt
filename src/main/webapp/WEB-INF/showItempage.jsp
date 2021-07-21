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
        Her er en liste med alt udstyr
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Navn</th>
                <th scope="col">Beskrivelse</th>
                <th scope="col">Lokale</th>
                <th scope="col">Type</th>


            </tr>
            <c:forEach var="item" items="${requestScope.itemList}">
                <tr>
                    <td>${item.item_id}</td>
                    <td>${item.item_name}</td>
                    <td>${item.item_tag}</td>
                    <td>${item.room_nr}</td>
                    <td>${item.item_type}</td>

                </tr>
            </c:forEach>
        </table>

    </jsp:body>

</t:genericpage>

