
<h2>Eating a box of Smarties</h2>

<form method="post" action="">
    <p>How many of each color do you want?</p>
    <p>
        <label for="red">Red</label>
        <input id="red" type="number" name="red" /><br>
    </p>
    <p>
        <label for="yellow">Yellow</label>
        <input id="yellow" type="number" name="yellow" /><br>
    </p>
    <p>
        <label for="blue">Blue</label>
        <input id="blue" type="number" name="blue" /><br>
    </p>
    <p>
        <label for="green">Green</label>
        <input id="green" type="number" name="green" /><br>
    </p>
    <input type="submit" name="submit" value="How many did I eat to date?" />
    <input type="submit" name="submit" value="I am done!!!" />
    <input type="submit" name="submit" value="Clear Choices" />
</form>
<?php
echo "<p>Today you have eaten:</p>";
$red = $_SESSION["red"];
$yellow = $_SESSION["yellow"];
$blue = $_SESSION["blue"];
$green = $_SESSION["green"];
$sum = $red + $yellow + $blue + $green;
echo "$red red ones</br>";
echo "$yellow yellow ones</br>";
echo "$blue blue ones</br>";
echo "$green green ones</br>";
echo "<p>For a grand total of $sum Smarties!</p>"
?>
