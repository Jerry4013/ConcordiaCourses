<!DOCTYPE html>
<html lang = "en">
  <head> 
    <title> animals </title>
    <meta charset = "utf-8" />
  </head> 
  <body> 
  <?php

$die="";
      if (isset ($_POST['sides'])) 
	  {
         $die = roll($_POST["sides"]);
	  }
 
function roll($sides) {
    return rand(1,$sides);
}
?>
<h3> Die Roller!!! </h3>
<form method="post">
<!--  @ suppresses error/warning messages -->
Sides : <input type="text" name="sides" value="<?php echo @$_POST['sides'] ?>"/> 
Result : <?php echo $die;  ?> 
<input type="submit" />
</form>
  </body>
</html>