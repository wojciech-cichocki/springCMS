<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form:form action="register" method="POST" modelAttribute="registerUserDTO" cssClass="register">
    <div>
        <form:input path="firstName" placeholder="FIRST NAME"/>
    </div>
    <div>
        <form:input path="lastName" placeholder="LAST NAME"/>
    </div>
    <div>
        <form:input path="login" placeholder="LOGIN"/>
    </div>
    <div>
        <form:input path="password" type="password" placeholder="PASSWORD"/>
    </div>
    <div>
        <form:input path="confirmPassword" type="password" placeholder="CONFIRM PASSWORD"/>
    </div>
    <p><form:errors path="*" cssClass="error"/></p>
    <p class="error">${otherError}</p>
    <input type="submit" value="REGISTER">
</form:form>