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

<h1> Comet </h1>
<h2> Parking </h2>
<div id="fillerdiv1"> </div>
<p> '${fn:escapeXml(successMsg)}' </p>
<p id="p1"> Registration Successful! 
<a href="Login.jsp" id="link1"> Click here to login </a>

 
</body>
</html>