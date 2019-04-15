<!DOCTYPE html>
<html>
<head>
    <title> PHP-Arrays </title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Looping Through an Array</h1>

<?php
  $cars = array("Volvo", "BMW", "Toyota");
  $arrlength = count($cars);

  for($x = 0; $x < $arrlength; $x++) {
    echo $cars[$x];
    echo "<br>";
  }
?>
</body>
</html>