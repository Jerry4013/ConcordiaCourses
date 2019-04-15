<h3>Eating a box of Smarties:</h3>

<form method="post" action="">
<p>How many of each color do you want?: <br /><br />
Red <input type="text" size="5" name="red" /><br /><br />
Yellow <input type="text" size="5" name="yellow" /><br /><br />
Blue <input type="text" size="5" name="blue" /><br /><br />
Green <input type="text" size="5" name="green" /><br /><br />

<input type="submit" name="submit" value=" How many did I eat to date? " /> 
&nbsp;
<input type="submit" name="submit" value=" I am done!!! " />
&nbsp;
<input type = "reset"  value = "Clear Choices" /></p>
</form>
<?php
    $red = $_SESSION["red"];
	$yellow = $_SESSION["yellow"];
	$blue = $_SESSION["blue"];
	$green = $_SESSION["green"];
    $total = $_SESSION["total"];
    echo 'To date you have eaten:<br />';
    echo "&nbsp;&nbsp;&nbsp;$red red ones <br />"; 
	echo "&nbsp;&nbsp;&nbsp;$yellow yellow ones <br />";
	echo "&nbsp;&nbsp;&nbsp;$blue blue ones <br />";
	echo "&nbsp;&nbsp;&nbsp;$green green ones <br /><br />";
	echo "For a grand total of $total Smarties!  <br />";
?>