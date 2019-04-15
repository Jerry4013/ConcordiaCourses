<!-- ReviewQ2_V1Sol.php-->
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

// Display 3 lowest grades
echo "<br> List of 3 lowest grades : ". "<br>"; 
$counter = 0;
 
foreach ($quiz_array as $q=>$q_grade)  
{ 
   if($counter < 3) echo "Name=" . $q . ", grade=" . $q_grade. "<br>"; 
	$counter++;		
} 

//Dislay 3 top grades
$counter = 0;
$count2= $quiz_array_length-3; 
echo "<br>List of 3 highest grades : ", "<br>";  
foreach ($quiz_array as $q=>$q_grade)  
{ 
   if($counter >= $count2) echo "Name=" . $q . ", grade=" . $q_grade. "<br>";
   $counter++;			
}
?> 
</body>
</html>