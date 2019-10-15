<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>luv2code Company Home Page</title>
</head>

<body>
    <h2>lub2code Company Home Page</h2>
    <hr>
    Welcome to the luv2code company home page!

    <!-- Add a logout button -->

    <form:form action="${pageContext.request.contextPath}/logout" method="post">
        <input type="submit" value="Logout"/>

    </form:form>
</body>
</html>