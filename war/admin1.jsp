<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.List,src.com.cometpark.server.model.InformationObj" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>

</head>
<body>

<% 
List<InformationObj> newList = List <InformationObj> request.getParameter("infoList"); 
// print the information about every category of the list
for(newList info : list) {
    out.println(info.getSpotId());
    out.println(info.getAvailibility());
    out.println(info.getDateValue());
	}
%>

<!-- Below form is to call the servlet and retrieve values. -->
<form action="/admin" method="get">
    <div><input type="submit" value="Click to view results"/></div>
</form>
<h1> Comet </h1>
<h2> Parking </h2>
<div id="fillerdiv1"> </div>

<p id="p1"> Choose function to perform: </p>

<div id="d1"> </div> 

<div id="d2"> </div> 

<p id="p2"> Manage Parking Lot </p>

<p id="p3"> Generate Parking Reports </p>

<a href="/Login.jsp" id="link1"> Log out </a>
 
</body>
</html>