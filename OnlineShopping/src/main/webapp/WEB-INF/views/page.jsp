<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title}</title>
    <script>
        window.menu = '${title}';
    </script>
    <!-- Bootstrap core CSS -->
    <link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

    <link href="${css}/bootstrap-readable-theme.css" rel="stylesheet">

</head>

<body>
<div class="wrapper">
    <%@include file="./shared/navbar.jsp"%>
    <div class="content">
        <c:if test="${userClickHome == true}">
            <%@include file="home.jsp"%>
        </c:if>
        <c:if test="${userClickAbout == true}">
            <%@include file="about.jsp"%>
        </c:if>
        <c:if test="${userClickContact == true}">
            <%@include file="contact.jsp"%>
        </c:if>
        <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">
            <%@include file="listProducts.jsp"%>
        </c:if>
    </div>
    <%@include file="./shared/footer.jsp"%>
    <script src="${js}/jquery.min.js"></script>
    <script src="${js}/popper.min.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/site.js"></script>
</div>

</body>

</html>


