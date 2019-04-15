<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>if1.php</title>
</head>
<body>
  <h1>Try to roll a six</h1>
  <p>
    <a href = "if1.php">roll again</a>
  </p>
  <?php
    $roll = rand(1,6);
    if ($roll == 6){
      print("<h1>Holy Guacamole! That's a six!</h1>\n");
	  }
	  else 
	  {
	  print("Roll is ".$roll);
	  }
   ?>
  
</body>
</html>