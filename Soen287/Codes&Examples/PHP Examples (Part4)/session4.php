<?php
session_start();
?>
<!DOCTYPE html>
<html>
<body>
<h2>We are in file session4.php and about to terminate session</h2>
<?php
// remove all session variables
session_unset();
print_r($_SESSION);

// destroy the session
session_destroy();

?>

</body>
</html> 