<?php require_once("sessionfns.php");

function processOrder()
{ $red =  $_POST["red"];
  if ( $red > 0 ) {  $_SESSION['red'] += $red; $_SESSION["total"] += $red;}
  $yellow =  $_POST["yellow"];
  if ( $yellow > 0 ) {  $_SESSION['yellow'] += $yellow; $_SESSION["total"]+= $yellow; }
  $blue =  $_POST["blue"];
  if ( $blue > 0 ) {  $_SESSION['blue'] += $blue; $_SESSION["total"]+= $blue; }
  $green =  $_POST["green"];
  if ( $green > 0 ) {  $_SESSION['green'] += $green; $_SESSION["total"] += $green; }
  
}

if( empty($_POST['submit']) ) 
{ 
  session_start();
  $_SESSION['red']=0;
  $_SESSION['yellow']=0;
  $_SESSION['green']=0;
  $_SESSION['blue']=0;
  $_SESSION['total']=0;
  include("head.php");
  require("orderform.php");
}
elseif ($_POST['submit'] == " How many did I eat to date? " )
{ session_start(); 
  processOrder();
  include("head.php");
  require("orderform.php");
}
elseif( $_POST['submit'] == " I am done!!! " )
{ session_start(); session_end(); 
//session_start();session_destroy();
  include("head.php");
  echo "<p>Hope you don't have a belly ache after eating all of those s
  Smarties!!!!</p>";
  echo '<p><a href="">Another Smarties eater on the horizon ....</a></p>';
} ?>
</body></html>
