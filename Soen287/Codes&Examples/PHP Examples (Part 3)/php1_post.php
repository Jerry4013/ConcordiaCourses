<?php
  if( isset($_POST['submit']) )
  {
     echo "Welcome ". $_POST['name']. "<br />";
     echo "You are ". $_POST['age']. " years old.";
  }
?>
<html>
<body>
  <br /><br />
  <form action="" method="POST">
  Name: <input type="text" name="name" />
  Age: <input type="text" name="age" />
  <input type="submit" name='submit' />
  </form>
</body>
</html>