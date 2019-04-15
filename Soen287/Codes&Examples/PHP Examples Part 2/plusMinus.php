<!DOCTYPE html>
<!--	plusMinus.php
 -->
<html lang = "en">
<head> 
  <title> plusMinus.php </title>
  <meta charset = "utf-8" />
</head>
<body>
<?php

function plusMinus($in_array, &$plus, &$minus) {

// Loop to store the numbers in the appropriate array

  foreach ($in_array as $num) {
    if($num < 0)
      $minus[]=$num;
    else
      if($num > 0)
				$plus[]=$num;
  }
} #** End of plusMinus

// Main test driver

  $test_array = array(1, 4, -4.5, 0, -3, 3.7, 0, 100);

// Create the two other arrays
   $positive = array();
   $negative = array();	
	 
// Call the function
   plusMinus($test_array,$positive, $negative);

// Display the arrays

  var_dump($test_array); print "<br />";
	var_dump($positive);  print "<br />";
	var_dump($negative);  print "<br />";
?>
</body>
</html>
