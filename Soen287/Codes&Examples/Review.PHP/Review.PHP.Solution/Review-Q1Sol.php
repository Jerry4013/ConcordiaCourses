<!-- Review-Q1Sol.php-->
    
<!DOCTYPE html>
<html>
<head>
    <title> Review 2 </title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Review 2-Question1</h1>

<?php  
//Declare and initialize variables
$quiz_array = array(10, 12, 8, 20, 20, 5, 17, 0, 15, 11, 19, 17, 10, 10, 9, 13); 
$avg_grd = 0;  
$quiz_array_length = count($quiz_array);  

//Calculate and display average
foreach($quiz_array as $temp)  
{  
 $avg_grd += $temp;  
}  
 $avg_grd = $avg_grd/$quiz_array_length;  
 echo "Average grade is : ".$avg_grd ."/20 ". "<br>";   
 
//Sort associative array
sort($quiz_array); 

// Display 3 lowest grades 
echo "<br> List of 3 lowest grades : ";  
for ($i=0; $i< 3; $i++)  
{   
echo $quiz_array[$i].", ";  
}  

//Dislay 3 top grades
echo "<br>List of 3 highest grades : ";  
for ($i=($quiz_array_length-3); $i< ($quiz_array_length); $i++)  
{  
echo $quiz_array[$i].", ";  
}  
?> 
</body>
</html>