<!DOCTYPE html>
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
font-size: 7em;
color: #ccff99;
text-shadow: 1px 1px #ff9966;
}

h2
{
position: absolute;
top: 0px;
left: 400px;
font-family: "Georgia";
font-size: 7em;
color: #ff9966;
text-shadow: 1px 1px #ccff99;
}

#fillerdiv1
{
position:absolute;
top: 215px;
background-color: grey;
width: 100%;
height: 5px;
}

#p1
{
position: absolute;
top: 180px;
left: 20px;
color: #ccff99;
font-family: "Georgia";
font-size: 4em;
text-decoration: underline;
}

#Username
{
position: absolute;
top: 320px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 3em;
}

#usernameBox
{
position: absolute;
top: 320px;
left: 225px;
font-size: 2em;
}

#Password
{
position: absolute;
top: 390px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 3em;
}

#passwordBox
{
position: absolute;
top: 390px;
left: 225px;
font-size: 2em;
}

input
{
padding: 5px;  
font-size: 15px;  
text-shadow: 0px 1px 0px #fff; 
background: -moz-linear-gradient(top,  #bcbcbe,  #ffffff);  
-moz-border-radius: 4px;  
border-radius: 4px;  
border: 1px solid #717171;   
}

input:focus 
{
    box-shadow: 0 0 5px rgba(255, 255, 255, 1);
    -moz-box-shadow: 0 0 10px rgba(255, 255, 255, 1); 
}

#submit1
{
position: absolute;
top: 475px;
left: 250px;
font-size: 2em;
}

#p2
{
position: absolute;
top: 490px;
left: 20px;
color: white;
font-family: "Georgia";
font-size: 3em;
}

#link1
{
position: absolute;
top: 540px;
left: 260px;
color: white;
font-family: "Georgia";
font-size: 3em;
}

#fillerdiv2
{
position:absolute;
top: 610px;
background-color: grey;
width: 100%;
height: 5px;
}

#p3
{
position: absolute;
top: 590px;
left: 20px;
color: #ff9966;
font-family: "Georgia";
font-size: 4em;
text-decoration: underline;
}

#UsernameAdmin
{
position: absolute;
top: 740px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 3em;
}

#usernameAdminBox
{
position: absolute;
top: 740px;
left: 220px;
font-size: 2em;
}

#PasswordAdmin
{
position: absolute;
top: 810px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 3em;
}

#passwordAdminBox
{
position: absolute;
top: 810px;
left: 220px;
font-size: 2em;
}

#submit2
{
position: absolute;
top: 890px;
left: 250px;
font-size: 2em;
}

#link2
{
position: absolute;
top: 970px;
left: 20px;
color: white;
font-family: "Georgia";
font-size: 3em;
}


</style>
</head>
<body>

<script>

function clear1()
{

	var form = document.getElementById("userLogin");
	form.reset();
	

}

function clear2()
{
var form = document.getElementById("adminlogin");
form.reset();
}

</script>


<h1> Comet </h1>
<h2> Parking </h2>
<div id="fillerdiv1"> </div>

<p id="p1"> User Login </p>

<form id="userlogin" action="guestbook.jsp">

<label for="username" id="Username"> Username: </label> <input id="usernameBox" type="text" name="userNameLogin">
<label for="password" id="Password"> Password: </label> <input id="passwordBox" type="password" name="passwordLogin">
<input type="submit" value="Submit" id="submit1">
</form>


<p id="errormessage"> </p>

<p id="p2"> New User? </p>
<a href="register.jsp" id="link1">Register here</a>

<div id="fillerdiv2"> </div>

<p id="p3"> Administrator Login </p>

<form id="adminlogin" action="admin.html" onsubmit="clear2()">

<label for="usernameAdmin" id="UsernameAdmin"> AdminID: </label> <input id="usernameAdminBox" type="text" name="usernameAdmin">
<label for="passwordAdmin" id="PasswordAdmin"> Password: </label> <input id="passwordAdminBox" type="password" name="passwordAdmin">
<input type="submit" value="Submit" id="submit2">
</form>

<a href="registerAdmin.jsp" id="link2">Register Admin here </a>

 
</body>
</html>