<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Address Book</title>
</head>
<body>
<%--TODO Bootstrap--%>
<%--TODO Correct names--%>
    <form id="addressForm"
          name="addressForm"
          role="form"
          action="<c:url value='/save' />"
          method="POST">

        <div>
            <label for="fullname">Full Name:</label>
            <input id="fullname" name="fullname" type="text">
        </div>

        <div>
            <label for="postcode">Post / ZIP code:</label>
            <input id="postcode" name="postcode" type="text">
        </div>

        <div>
            <label for="country">Country</label>
            <input id="country" name="country" type="text">
        </div>

        <div>
            <label for="region">Region / State / County</label>
            <input id="region" name="region" type="text">
        </div>

        <div>
            <label for="city">City</label>
            <input id="city" name="city" type="text">
        </div>

        <div>
            <label for="address1">Address 1</label>
            <input id="address1" name="address1" type="text">
        </div>

        <div>
            <label for="address2">Address 2</label>
            <input id="address2" name="address2" type="text">
        </div>

        <button type="submit">Save</button>
    </form>

    <table>
        <thead>
            <th>#</th>
            <th>Fullname</th>
            <th>Postcode</th>
            <th>Country</th>
            <th>Region</th>
            <th>City</th>
            <th>Address 1</th>
            <th>Address 2</th>
        </thead>
        <tbody>
            <c:forEach varStatus="status" var="address" items="${addresses}">
            <tr>
                <td>${status.index + 1}</td>
                <td>${address.fullname}</td>
                <td>${address.postcode}</td>
                <td>${address.country}</td>
                <td>${address.region}</td>
                <td>${address.city}</td>
                <td>${address.address1}</td>
                <td>${address.address2}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>