<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>staticVar.php</title>
</head>
<body>

<?php
echo "Adapted from http://www.w3schools.com/php/php_variables.asp<br />";
function myTest() {
     static $x = 0;
     echo $x,"<br />";
     $x++;
}
myTest();
myTest();
myTest();
?> 

</body>
</html>