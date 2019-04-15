<?php require_once("sessionfns.php");

function processOrder()
{ $cr =  $_POST["crust"];
  if ( $cr ) {  $_SESSION['crust'] = $cr; }
  $top = $_SESSION['toppings'];
  $it = $_POST["top"];
  if ( $it && ! strstr($top,$it) ) 
  { if ( $top ) { $_SESSION['toppings'] = "$top, $it";  }
    else { $_SESSION['toppings'] = $it;  }
  }
}

if( empty($_POST['submit']) )                                   //A
{ 
  session_start();  // before any output                        //B
  $_SESSION['crust']="";                                        //C
  $_SESSION['toppings']="";
  include("head.php");
  require("orderform.php");                                     //D
}
elseif ($_POST['submit'] == " Enter " )  // continuing           //E
{ session_start();  // before any output 
  processOrder();                                                //F
  include("head.php");
  require("orderform.php");
}
elseif( $_POST['submit'] == " Done " )                           //G
{ session_start(); session_end(); 
//session_start();session_destroy();                               //H
  include("head.php");
  echo '<p>Your order is complete.
        Thanks for your business.</p>';
  echo '<p><a href="">Another Order</a></p>';
} ?>
</body></html>
