<!-- Review-Q1.php
     Soen287/Review of PHP arrays
     -->
<!DOCTYPE html>
<html>
<head>
    <title> Review  </title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Review-Question1</h1>

<?php  
//Declare and initialize variables
$quiz_array = array(10, 12, 8, 20, 20, 5, 17, 0, 15, 11, 19, 17, 10, 10, 9, 13);
$sum = 0;
$length = count($quiz_array);
foreach ($quiz_array as $value)
    $sum += $value;
$avg = $sum / count($quiz_array);
echo "The average grade is: $avg.<br>";

sort($quiz_array);
$top = 0;
$top3 = array_slice($quiz_array, 0, 3);
echo "The lowest three grades are: $top3[0], $top3[1], $top3[2].<br>";
echo "The top three grades are: ";
for ($i = $length - 1; $i > $length - 4; $i--){
    echo "$quiz_array[$i], ";
}
?> 
</body>
</html>