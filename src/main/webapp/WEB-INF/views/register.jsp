<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!--HEADER-->
<jsp:include page="../elements/header.jsp" />

<section class="app-container">
    <!--LEFT BAR-->
    <div class="container-box">
    </div>

    <!--CONTENT-->
    <div class="content">
        <jsp:include page="../elements/register-form.jsp" />
    </div>

    <!--RIGHT BAR-->
    <div class="container-box">
        <jsp:include page="../elements/main-navigation.jsp" />
    </div>
</section>

<!--FOOTER-->
<jsp:include page="../elements/footer.jsp" />
</body>
</html>
</html>
