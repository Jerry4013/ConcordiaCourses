<?php
session_start();
?>
<!DOCTYPE html>
<html>
<body>
<h2>We are in file session2.php</h2>
<?php
// Echo session variables that were set on previous page
echo "Animal: " . $_SESSION["animal"] . ".<br>";
echo "Color: " . $_SESSION["animalColor"] . ".";
?>

</body>
</html>