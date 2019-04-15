<!DOCTYPE html>
<html>
<head>
    <title> PHP-do...while loop </title>
    <meta charset = "utf-8" />
</head>
<body>

<h1>Logical Operators PHP page</h1>

<?php 
  $i=0; $num=50;
  do {   
		$num--;
		$i++;	
	}while ($i < 1);	
	echo ("Loop stopped at $i<br />\$num is now $num");
?>
  
</body>
</html>