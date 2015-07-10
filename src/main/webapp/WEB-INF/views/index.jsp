<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Address Book</title>
</head>
<body>
<%--TODO Bootstrap--%>
<%--TODO Correct names--%>
    <div>
        <c:out value="${msg}"/>
    </div>
    <form:form
          commandName="address"
          role="form"
          action="/save"
          method="POST">

        <form:errors path="*" element="div" cssClass="errorMsg" />

        <div>
            <label for="fullname">Full Name:</label>
            <form:input id="fullname" path="fullname" type="text"/>
        </div>

        <div>
            <label for="postcode">Post / ZIP code:</label>
            <form:input id="postcode" path="postcode" type="text"/>
        </div>

        <div>
            <label for="country">Country</label>
            <form:input id="country" path="country" type="text"/>
        </div>

        <div>
            <label for="region">Region / State / County</label>
            <form:input id="region" path="region" type="text"/>
        </div>

        <div>
            <label for="city">City</label>
            <form:input id="city" path="city" type="text"/>
        </div>

        <div>
            <label for="address1">Address 1</label>
            <form:input id="address1" path="address1" type="text"/>
        </div>

        <div>
            <label for="address2">Address 2</label>
            <form:input id="address2" path="address2" type="text"/>
        </div>

        <button type="submit">Add</button>
    </form:form>

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
            <c:forEach varStatus="status" var="addr" items="${addresses}">
            <tr>
                <td>${status.index + 1}</td>
                <td>${addr.fullname}</td>
                <td>${addr.postcode}</td>
                <td>${addr.country}</td>
                <td>${addr.region}</td>
                <td>${addr.city}</td>
                <td>${addr.address1}</td>
                <td>${addr.address2}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>