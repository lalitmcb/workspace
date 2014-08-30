<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
 $(document).ready(function() {
	$("#userListGrid").jqGrid({ 
	  url: "<c:url value='/ws/rest/users'/>", 
	  datatype: "JSON", 
	  mtype: "GET", 
	  colNames: ['First Name', 'Last Name', 'Email', 'Role', 'Status'], 
	  colModel: [ {name: 'firstName', index: 'firstName', width: 250}, 
	              {name: 'lastName', index: 'lastName',  width: 250},
	              {name: 'email', index: 'email', width: 250},
	              {name: 'role', index: 'role', width: 250},
	              {name: 'status', index: 'status', width: 250}],
	  sortname: 'First Name', 
	  viewrecords: true, 
	  sortorder: 'desc', 
	  caption: 'Users List'
	  });
 });
 
 console.log("Reached here");
 </script>

<table id="userListGrid">
   <tr><td></td></tr>
</table>
