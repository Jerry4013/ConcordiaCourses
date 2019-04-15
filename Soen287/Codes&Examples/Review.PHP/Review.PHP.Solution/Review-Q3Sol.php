<!-- ReviewQ3Sol.php-->
<!DOCTYPE html>
<html>
<head>
    <title> Review </title>
    <meta charset = "utf-8" />
</head>
<body>
<h1>Review-Question 3</h1>

<?php 
// Function to calculate average which is returned and sort array
function avgSort(&$grades)
{
  asort($grades);
  $avg_grd = 0;
  $grades_length = count($grades);  
  foreach($grades as $temp)  
  {  
   $avg_grd += $temp;  
  }  
  return $avg_grd/$grades_length;  
}#** End of avgSort()

// Main test driver
//------------------


// Declare and initialize associative array
$quiz_array = array("Abe"=>"10","Bea"=>"12","Carl"=>"8", "Dahlia"=>"20", "Evan"=>"20",
  "Flo"=>"5", "Gary"=>"17", "Helen"=>"0", "Ian"=>"15", "Jen"=>"11", "Karl"=>"19",
  "Lynn"=>"17","Max"=>"10","Nicole"=>"10","Oscar"=>"9","Pam"=>"13");  

//Display average which is returned from function  
 echo "Average grade is : ".avgSort($quiz_array) ."/20 ". "<br>";   

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
$quiz_array_length = count($quiz_array);
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