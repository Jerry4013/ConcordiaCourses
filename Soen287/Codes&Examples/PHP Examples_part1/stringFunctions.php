<!DOCTYPE html>
<html>
<head>
    <title> PHP-String functions </title>
    <meta charset = "utf-8" />
</head>
<body>

<h1>String Trim PHP page</h1>
<?php   
  $first = 'john...';   $last = "Smith";
	echo  (trim($first,".")."<br />");
	echo  (strlen($first)."<br />");
	echo  (strstr("John Smith","mi").'<br />');
	echo  (ucwords("john SMITH").'<br />');
	echo  (strcmp("Hello", "hello"));
?>
</body>
</html>




