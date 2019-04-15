<?php
// Start the session
session_start();
?>
<!DOCTYPE html>
<html>
<body>
<h2>We are in file session1.php</h2>
<?php
// Set session variables
$_SESSION["animal"] = "elephant";
$_SESSION["animalColor"] = "grey";
echo "Session variables are set:<br />";
print_r($_SESSION);
?>
</body>
</html>