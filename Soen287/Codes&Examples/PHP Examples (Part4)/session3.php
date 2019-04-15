<?php
session_start();
?>
<!DOCTYPE html>
<html>
<body>
<h2>We are in file session3.php</h2>
<?php
// to change a session variable, just overwrite it
$_SESSION["animal"] = "Rottweiler-Sheppard mix";
print_r($_SESSION);
?>

</body>
</html>