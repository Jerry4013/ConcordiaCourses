<!DOCTYPE html>
<!--	pattern.php
 -->
<html lang = "en">
<head> 
  <title> pattern.php </title>
  <meta charset = "utf-8" />
</head>
<body>
<h3> Demonstating Pattern matching in PHP </h3>
<?php
  $name="John Smith";
 	if(preg_match("/^J/",$name))
	  echo $name," begins with J.";
	else
	  echo $name," does not begins with J.";
	echo "<br />";
	
	$name="John Smith";
 	if(preg_match("/^J/",$name))
	  echo $name," begins with J.";
	else
	  echo $name," does not begins with J.";
	echo "<br />";
	
 	if(preg_match("/J/",$name))
	  echo $name," contains a J.";
	else
	  echo $name," does not contains a J.";
	echo "<br />";
	
	if(preg_match("/n/",$name))
	  echo $name," contains a j.";
	else 
	  echo $name," does not contains a j.";
	echo "<br />";
	
?>
</body>
</html>
