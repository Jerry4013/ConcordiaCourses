<?php
  if( isset($_GET['submit']) )
  {
     echo "Welcome ". $_GET['name']. "<br />";
     echo "You are ". $_GET['age']. " years old.";
  }
  else
	echo "";
?>
<html>
<body>
  <br /><br />
  <form action="" method="GET">
  Name: <input type="text" name="name" />
  Age: <input type="text" name="age" />
  <input type="submit" name='submit'/>
  </form>
</body>
</html>