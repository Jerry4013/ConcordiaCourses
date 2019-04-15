<!DOCTYPE html>
<html>
<head>
    <title> PHP-Trim functions </title>
    <meta charset = "utf-8" />
</head>
<body>

<h1>String Trim PHP page</h1>

<?php
	$str = "Hello World!";
	echo $str . "<br>";
	echo trim($str,"Held!");
?>
</body>
</html>