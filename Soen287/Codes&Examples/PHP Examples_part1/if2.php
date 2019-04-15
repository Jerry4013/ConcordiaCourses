<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>if2.php</title>
</head>
<body>
  <h1>Try to roll a six!</h1>
  <p>
    <a href = "if2.php">roll again</a>
  </p>
  <?php
    //thanks to user rg1024 from openClipart.org for
    //the great dice images
    $roll = rand(1,6);
    print <<<HERE
<p>
    <img src = "images/dado_$roll.png"
         alt = "$roll"
         height = "100px"
         width = "100px" />
</p>
HERE;
    if ($roll == 6){
      print("<h1>Holy Guacamole! That's a six!</h1>\n");
    } // end if
  ?>
</body>
</html>
