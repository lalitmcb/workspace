<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en" ng-app="portalApp">
<head>
<title><spring:message code="title" /></title>
<link
	href="<c:url value='/resources/css/bootstrap/3.2.0/bootstrap.min.css'  />"
	rel="stylesheet" />
<link
	href="<c:url value='/resources/css/bootstrap/3.2.0/bootstrap-theme.min.css'  />"
	rel="stylesheet" />
<script
	src="<c:url value='/resources/js/jquery/2.1.1/jquery-2.1.1.min.js' />"></script>
<script
	src="<c:url value='/resources/js/angular/1.2.19/angular.min.js' />"></script>
<script
	src="<c:url value='/resources/js/portal/restaurantController.js' />"></script>
</head>
<body ng-controller="RestaurantController">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				Search: <input ng-model="query">
			</div>
			<div class="col-md-10">
				<ul class="restaurants">
					<li ng-repeat="resturants in restaurant">{{restaurant.name}}</li>
				</ul>

			</div>
		</div>
	</div>


	Nothing here {{'yet' + '!'}}
	<h1>Login</h1>
	<form name='f' action="j_spring_security_check" method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value='lalit'></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' value='lalit' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>

</body>
</html>