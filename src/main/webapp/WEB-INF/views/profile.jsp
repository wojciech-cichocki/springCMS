<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css" />
    <title>${user.login}</title>
</head>
<body>
<%--HEADER--%>
<jsp:include page="../elements/header.jsp" />

<section class="app-container">
    <!--LEFT BAR-->
    <div class="container-box">
    </div>

    <!--CONTENT-->
    <div class="content">
        <jsp:include page="../elements/personal-data.jsp" />
    </div>

    <!--RIGHT BAR-->
    <div class="container-box">
        <jsp:include page="../elements/account-navigation.jsp" />
    </div>
</section>

<%--<jsp:include page="/WEB-INF/elements/footer.jsp" />--%>
<jsp:include page="../elements/footer.jsp" />
</body>
</html>