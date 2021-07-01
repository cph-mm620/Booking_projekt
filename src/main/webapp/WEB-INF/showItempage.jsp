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
        <table class ="table table-striped">
            <c:forEach var="item" items="${requestScope.itemList}">
                <tr>
                    <td>${item.item_id}</td>
                    <td>${item.item_name}</td>
                    <td>${item.item_type}</td>
                    <td>${item.item_tag}</td>
                    <td>
                        <button class="btn btn-success" type="submit">Book</button></td>
                </tr>

            </c:forEach>
        </table>
    </jsp:body>

</t:genericpage>

