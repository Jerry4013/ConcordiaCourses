<?php require_once("sessionfns.php");

function processOrder(){
    $red =  $_POST["red"];
    if ( $red ) {
      $_SESSION['red'] += $red; }

    $yellow =  $_POST["yellow"];
    if ( $yellow) {
        $_SESSION['yellow'] += $yellow; }

    $blue =  $_POST["blue"];
    if ( $blue ) {
        $_SESSION['blue'] += $blue; }

    $green =  $_POST["green"];
    if ( $green ) {
        $_SESSION['green'] += $green; }
}

if( empty($_POST['submit']) )                                   //A
{ 
  session_start();  // before any output                        //B
  $_SESSION['red']=0;                                        //C
  $_SESSION['yellow']=0;
  $_SESSION['blue']=0;
  $_SESSION['green']=0;
  include("head.php");
  require("orderform.php");                                     //D
}
elseif ($_POST['submit'] == "How many did I eat to date?" )  // continuing           //E
{ session_start();  // before any output 
  processOrder();                                                //F
  include("head.php");
  require("orderform.php");
}
elseif( $_POST['submit'] == "I am done!!!" )                           //G
{ session_start(); session_end(); 
//session_start();session_destroy();                               //H
  include("head.php");
  echo '<p>Hope you don\'t have a belly ache after eating all of those Smarties!!!!
        </p>';
  echo '<p><a href="">Another Smarties eater on the horizen...</a></p>';
}
elseif( $_POST['submit'] == "Clear Choices" ){
    session_start();
    new_session();                        //B
    $_SESSION['red']=0;                                        //C
    $_SESSION['yellow']=0;
    $_SESSION['blue']=0;
    $_SESSION['green']=0;
    include("head.php");
    require("orderform.php");
}
?>
</body></html>
