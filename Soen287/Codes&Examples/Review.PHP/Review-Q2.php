<!-- ReviewQ2.php
     Soen287/Review of PHP associative arrays
     -->
<!DOCTYPE html>
<html>
<head>
    <title> Review </title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Review-Question 2/Version 1</h1>

<?php 
//Declare and initialize variables
$quiz_array = array("Abe"=>"10","Bea"=>"12","Carl"=>"8", "Dahlia"=>"20", "Evan"=>"20",
  "Flo"=>"5", "Gary"=>"17", "Helen"=>"0", "Ian"=>"15", "Jen"=>"11", "Karl"=>"19",
  "Lynn"=>"17","Max"=>"10","Nicole"=>"10","Oscar"=>"9","Pam"=>"13");  

$length = count($quiz_array);
$avg = 0;
foreach ($quiz_array as $item) {
    $avg += $item;
}
$avg = $avg / $length;

echo "Average grade is : ".$avg ."/20 ". "<br>";

?>

</body>
</html>