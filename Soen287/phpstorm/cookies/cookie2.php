

<?php
// set the expiration date to one hour ago
setcookie("user", "", time()-3600);


if(!isset($_COOKIE["user"])) {
    echo "Cookie named is not set!";
} else {
    echo "Cookie '" . "user" . "' is set!<br>";
    echo "Value is: " . $_COOKIE["user"];
}
?>


