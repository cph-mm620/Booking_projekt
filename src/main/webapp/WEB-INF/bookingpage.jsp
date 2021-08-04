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

        <form action="${pageContext.request.contextPath}/fc/confirmbookingpage" method="post">

            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Udstyrs nr</th>
                    <th scope="col">Navn</th>
                    <th scope="col">Type</th>
                    <th scope="col">lokale</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="item" items="${requestScope.itemList}">
                    <div class="d-flex align-items-center">
                        <div class="flex-grow-3 ms-5 form">
                            <tr>
                                <td>${item.item_id}</td>
                                <td>${item.item_name}</td>
                                <td>${item.item_type}</td>
                                <td>${item.description}</td>
                                <td>${item.room_nr}</td>

                                <td> <select class="form-select mt-4" name="days${item.item_id}">
                                    <option text="antal dage">antal dage</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                </select></td>
                                <td><button type="submit" class="mt-3 btn btn-success align-items-center" name="item" value="${item.item_id}">Book</button></td>
                            </tr>
                        </div>
                    </div>
                </c:forEach>
                </tbody>
            </table>
        </form>
    </jsp:body>

</t:genericpage>

