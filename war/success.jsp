<%@ page import="com.google.appengine.api.datastore.DatastoreService" %>
<%@ page import="com.google.appengine.api.datastore.DatastoreServiceFactory" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<%@ page import="com.google.appengine.api.datastore.FetchOptions" %>
<%@ page import="com.google.appengine.api.datastore.Key" %>
<%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<%@ page import="com.google.appengine.api.datastore.Query" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<html>
<head>
<style>
body 
{
background-color:black;
}

h1
{
position: absolute;
top: 10px;
left: 20px;
font-family: "Georgia";
font-size: 70px;
color: #ccff99;
text-shadow: 1px 1px #ff9966;
}

h2
{
position: absolute;
top: 0px;
left: 260px;
font-family: "Georgia";
font-size: 70px;
color: #ff9966;
text-shadow: 1px 1px #ccff99;
}

#fillerdiv1
{
position:absolute;
top: 150px;
background-color: grey;
width: 550px;
height: 5px;
}

#p1
{
position: absolute;
top: 160px;
left: 20px;
color: #99cccc;
font-family: "Georgia";
font-size: 35px;
}

#p2
{
position: absolute;
top: 190px;
left: 20px;
color: #99cccc;
font-family: "Georgia";
font-size: 35px;
}

#link1
{
position: absolute;
top: 70px;
left: 0px;
color: #99cccc;
font-family: "Georgia";
font-size: 25px;
}
</style>
</head>
<body>
	

<%
	String userVal = request.getParameter("userName");
	
	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	Key k = KeyFactory.createKey("UserObject",userVal );
	Entity userName = datastore.get(k);
	String userValue = userName.getProperty("userName").toString();
		
%>

<h1> Comet </h1>
<h2> Parking </h2>
<div id="fillerdiv1"> </div>

<p id="p2"> Thank you for registering, <% out.println(userValue); %> </p>
<p id="p1"> Registration Successful! 
<a href="Login.jsp" id="link1"> Click here to login </a>

 
</body>
</html>