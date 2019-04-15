<!DOCTYPE html>
<html>
<head>
    <title> PHP-For loop </title>
    <meta charset = "utf-8" />
</head>
<body>

<h1>For Loop PHP page</h1>

<?php 
  $a=0; $b=0;
	for( $i=0;$i<5;$i++)
	{
		$a +=10; $b += 5;
	}
	echo("at the end of the loop a=$a and b=$b");
?>

</body>
</html>