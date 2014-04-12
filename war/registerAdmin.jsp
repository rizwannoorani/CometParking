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
font-size: 30px;
}

#Username
{
position: absolute;
top: 250px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 25px;
}

#usernameBox
{
position: absolute;
top: 250px;
left: 230px;
}

#Password
{
position: absolute;
top: 305px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 25px;
}

#passwordBox
{
position: absolute;
top: 305px;
left: 230px;
}

#PasswordConfirm
{
position: absolute;
top: 365px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 25px;
}

#passwordConfirmBox
{
position: absolute;
top: 365px;
left: 230px;
}

#Netid
{
position: absolute;
top: 415px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 25px;
}

#netidBox
{
position: absolute;
top: 420px;
left: 230px;
}

#Dropdown
{
position: absolute;
top: 475px;
left: 20px;
color: white;
font-family: "Times New Roman";
font-size: 25px;
}

#dropdown
{
position: absolute;
top: 475px;
left: 230px;
}

#submit1
{
position: absolute;
top: 500px;
left: 80px;
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


option
{
color:white;
}

#p2
{
position: absolute;
top: 580px;
font-family: "Georgia";
font-size: 20px;
}

#link1
{
position: absolute;
top: 580px;
left: 250px;
font-family: "Georgia";
font-size: 20px;
}

</style>

</head>
<body>

<h1> Comet </h1>
<h2> Parking </h2>
<div id="fillerdiv1"> </div>

<p id="p1"> Please fill out the details below to register as Administrator: </p>


<form id="userregister" action="success.html">

<label for="username" id="Username"> Username: </label> <input id="usernameBox" type="text" name="username">
<label for="password" id="Password"> Password: </label> <input id="passwordBox" type="password" name="password">
<label for="passwordConfirm" id="PasswordConfirm"> Confirm Password: </label> <input id="passwordConfirmBox" type="password" name="passwordConfirm">
<label for="netid" id="Netid"> Employee ID: </label> <input id="netidBox" type="text" name="netid">

<input type="submit" value="Register" id="submit1">
</form>

</body>
</html>