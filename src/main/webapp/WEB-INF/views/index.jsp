<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Address Book</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <script src="/js/lib/jquery-2.1.4.min.js"></script>
    <link rel="stylesheet" href="/js/lib/bootstrap/css/bootstrap.min.css">
    <script src="/js/lib/bootstrap/js/bootstrap.min.js"></script>
    <script src="/js/phones.js"></script>
</head>
<body>
    <div class="container" >
        <h1 class="text-center header">Address Book</h1>
        <hr class="divider"/>

        <c:if test="${not empty msg}">
            <div class="alert alert-info">
                <c:out value="${msg}"/>
            </div>
        </c:if>

        <form:form
              commandName="address"
              role="form"
              cssClass="form-horizontal"
              action="/save"
              method="POST">

            <form:errors path="*" element="div" cssClass="alert alert-danger" />

            <div class="form-group">
                <label for="fullname" class="col-sm-2 control-label">Full Name</label>
                <div class="col-sm-10">
                    <form:input id="fullname" path="fullname" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="address1" class="col-sm-2 control-label">Address Line 1</label>
                <div class="col-sm-10">
                    <form:input id="address1" path="address1" type="text" class="form-control"
                                placeholder="Street, P.O. box, company name, c/o"/>
                </div>
            </div>

            <div class="form-group">
                <label for="address2" class="col-sm-2 control-label">Address Line 2</label>
                <div class="col-sm-10">
                    <form:input id="address2" path="address2" type="text" class="form-control"
                                placeholder="Apartment, suite, unit, building, floor"/>
                </div>
            </div>

            <div class="form-group">
                <label for="city" class="col-sm-2 control-label">City</label>
                <div class="col-sm-10">
                    <form:input id="city" path="city" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="region" class="col-sm-2 control-label">Region / State</label>
                <div class="col-sm-10">
                    <form:input id="region" path="region" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="postcode" class="col-sm-2 control-label">Postal / ZIP Code</label>
                <div class="col-sm-10">
                    <form:input id="postcode" path="postcode" type="text" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label for="country" class="col-sm-2 control-label">Country</label>
                <div class="col-sm-10">
                    <form:input id="country" path="country" type="text" class="form-control"/>
                </div>
            </div>

            <c:forEach varStatus="status" var="phone" items="${address.phones}">
            <div class="form-group">
                <label for="phone${status.index}" class="col-sm-2 control-label"><c:if test="${status.index == 0}">Phones</c:if></label>
                <div class="col-sm-10">
                    <form:input id="phone${status.index}" path="phones[${status.index}]" type="text" class="form-control"/>
                </div>
            </div>
            </c:forEach>



            <div class="form-group">
                <div class="col-sm-2"></div>
                <div class="col-sm-10">
                    <script>$(document).ready(function() { startPhones(${address.phones.size()}); });</script>
                    <button type="button" class="btn btn-default add-phone" onclick="">+</button>
                </div>
            </div>

            <button type="submit" class="btn btn-primary btn-block">Add</button>
        </form:form>

        <c:if test="${!addresses.isEmpty()}">

            <hr class="divider"/>
            <table class="table">
                <thead>
                    <th class="col-number">#</th>
                    <th>Full Name</th>
                    <th>Address Line 1</th>
                    <th>Address Line 2</th>
                    <th>City</th>
                    <th>Region</th>
                    <th>Postal Code</th>
                    <th>Country</th>
                    <th>Phones</th>
                </thead>
                <tbody>
                    <c:forEach varStatus="status" var="addr" items="${addresses}">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${addr.fullname}</td>
                        <td>${addr.address1}</td>
                        <td>${addr.address2}</td>
                        <td>${addr.city}</td>
                        <td>${addr.region}</td>
                        <td>${addr.postcode}</td>
                        <td>${addr.country}</td>
                        <td>
                            <c:forEach varStatus="status" var="phone" items="${addr.phones}">
                                <c:out value="${phone}"/><br/>
                            </c:forEach>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>