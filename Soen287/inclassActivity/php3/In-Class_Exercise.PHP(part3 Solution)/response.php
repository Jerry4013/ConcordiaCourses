<!DOCTYPE html>
 
<html lang="en">
<head>
<title>Simple Response - Favorite Animal</title>
</head>
 
<body>
<h2>Favorite Animal</h2>
 
<?php
//Retrieve string from post submission
$animal = $_POST['animal'];
echo "Your favorite animal is $animal.";
 
?>
 
</body>
</html>