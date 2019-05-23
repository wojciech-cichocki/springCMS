<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form action="login" method="POST" modelAttribute="loginUserDTO" cssClass="register">
    <div>
        <form:input path="login" placeholder="LOGIN"/>
        <form:input path="password" type="password" placeholder="PASSWORD"/>
    </div>
    <p><form:errors path="*" cssClass="error"/></p>
    <p class="error">${otherError}</p>
    <input type="submit" value="LOG IN">
</form:form>
