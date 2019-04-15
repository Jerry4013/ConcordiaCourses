<!DOCTYPE html>
<html>
<head>
    <title> PHP-Conditionals </title>
    <meta charset = "utf-8" />
</head>
<body>

<h1>conditionals PHP page</h1>
<?php   
  $num = 8;   
	if($num%2 == 0)
	    $msg= "$num is an even number";
	else
	    $msg = "$num is an odd number";
	echo ($msg);
?>

</body>
</html>