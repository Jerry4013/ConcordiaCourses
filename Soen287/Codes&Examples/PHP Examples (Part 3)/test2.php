  <?php 
  include('test1.php');
  echo "$var <br/>";     // "prints" 20 
  $var = 30; 
  include('test1.php');
  echo "$var <br/>";    // "prints" 20 again