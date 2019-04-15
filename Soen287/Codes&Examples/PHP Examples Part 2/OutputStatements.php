<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>OutputStatements.php</title>
</head>
<body>
  <h2>Output Statements</h2>
    <?php
      //first make an array of cars
	  $num=123;
	  $name="John Smith";
      $cars = array("hisCar" => "Austin Healey",
                    "myCar" => "BMW",
                    "Camaro",
                    "Datsun",
                    "Ferrari",
                    "kidsCar" =>"Hyunda",
                    "Jaguar",
                    "herCar"=>"Lamborghini");

      // Print/echo a string
	  echo "<h3>Output a string</h3>";
	  print $name;
	  print "<br />";
	  echo $name, "<br />";
	  echo ($name);
	  echo ("<br />");
	  
	  // Print/echo an array
	   echo "<h3>Output an array</h3>";
	  print $cars;
	  print "<br />";
	  echo $cars, "<br />";
	  
	  // Print/echo an array using foreach loop
	  echo "<h3>Output an array with foreach loop and print</h3>";
	  foreach ($cars as $x) {
	     print $x; print "<br />";}
	   print "<br />"; 
	   
	    echo "<h3>Output an array with foreach loop and echo</h3>";
	  foreach ($cars as $x) {
	    echo $x ,"<br />";}
	
      //Print/echo keys and values	
	  echo "<h3>Output an keys and values of an array with foreach loop and print</h3>";
	  foreach ($cars as $x=>$x_value) {
	     print "Key=";
		   print $x; 
		   print ", Value=";
		   print $x_value;
		   print "<br />";
		 }
		 print "<br />";
		 
	  echo "<h3>Output  keys and values of an array with foreach loop and echo</h3>";
	  foreach ($cars as $x=>$x_value) 
	    echo "Key=".$x.", Value=".$x_value."<br>";
		echo "<br />";
		
		echo "<h3>var_dump of an array, a string and an integer</h3>";
		var_dump($cars);  print "<br />";
		var_dump($name);  print "<br />";
		var_dump($num);   print "<br />";
		
		echo "<br />";
		echo "<h3>print_r of an array, a string and an integer</h3>";
		print_r($cars); print "<br />";
		print_r($name); print "<br />";
		print_r($num);  print "<br />";
      ?>
</body>
</html>