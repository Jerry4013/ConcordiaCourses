<!-- ReviewQ2_V2Sol.php-->
<!DOCTYPE html>
<html>
<head>
    <title> Review</title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Review-Question 2/Version 2</h1>

<?php 
//Declare and initialize variables
$quiz_grades = "10, 12, 8, 20, 20, 5, 17, 0, 15, 11, 19, 17, 10, 10, 9, 13";  
$quiz_array = array("Abe"=>"10","Bea"=>"12","Carl"=>"8", "Dahlia"=>"20", "Evan"=>"20",
  "Flo"=>"5", "Gary"=>"17", "Helen"=>"0", "Ian"=>"15", "Jen"=>"11", "Karl"=>"19",
  "Lynn"=>"17","Max"=>"10","Nicole"=>"10","Oscar"=>"9","Pam"=>"13");  
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
asort($quiz_array);
  
// Extract keys and values after associative array has been sorted.
$quiz_keys=array_keys($quiz_array);
$quiz_values=array_values($quiz_array);

// Display 3 lowest grades
echo "<br> List of 3 lowest grades : ". "<br>"; 
for ($i=0; $i< 3; $i++)  
{   
   echo "Name=" . $quiz_keys[$i] . ", grade=" . $quiz_values[$i]. "<br>"; 
} 

//Dislay 3 top grades
echo "<br>List of 3 highest grades : ", "<br>";
for ($i=$quiz_array_length-3; $i< $quiz_array_length; $i++)  
{   
   echo "Name=" . $quiz_keys[$i] . ", grade=" . $quiz_values[$i]. "<br>"; 
}
?> 
</body>
</html>