<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="">
<head>
        <title><spring:message  code="title" /></title>
        <link href="<c:url value='/resources/css/bootstrap/3.2.0/bootstrap.min.css'  />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/bootstrap/3.2.0/bootstrap-theme.min.css'  />" rel="stylesheet"/>
        <script src="<c:url value='/resources/js/jquery/2.1.1/jquery-2.1.1.min.js' />"></script>
        <script src="<c:url value='/resources/js/angular/1.2.19/angular.min.js' />"></script>
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />
 
            <tiles:insertAttribute name="body" />
        </div>
 
        <!--[if IE]>
            <script src="<c:url value='/resources/js/bootstrap.min.ie.js' />"></script>
        <![endif]-->
        <!--[if !IE]><!-->
            <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <!--<![endif]-->
 
        <tiles:insertAttribute name="footer" />
    </body>
</html>