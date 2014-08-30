<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="pt-BR" id="ng-app" ng-app="">
<head>
        <title><spring:message  code="title" /></title>
        <!-- jquery  -->
        <script src="<c:url value='/resources/js/jquery/jquery-2.1.1.min.js'/>"></script>
        
        <!-- jquery ui -->
        <script src="<c:url value='/resources/js/jquery/jquery-ui-1.11.1.min.js'/>"></script>
        <link href="<c:url value='/resources/css/jquery/jquery-ui-1.11.1.min.css' />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/jquery/jquery-ui.structure-1.11.1.min.css' />" rel="stylesheet"/>
        <link href="<c:url value='/resources/css/jquery/jquery-ui.theme-1.111.1.min.css' />" rel="stylesheet"/>
        
        <!-- jquery grid -->
        <script src="<c:url value='/resources/js/jquery/jquery.jqGrid-4.6.0.min.js'/>"></script>
        <link href="<c:url value='/resources/css/jquery/ui.jqgrid-4.6.0.css' />" rel="stylesheet"/>        
    </head>
    <body>
        <div class="container">
            <tiles:insertAttribute name="header" />
 
            <tiles:insertAttribute name="body" />
        </div>
        <tiles:insertAttribute name="footer" />
    </body>
</html>