<?php
$cookie_name = "user";
$cookie_value = "Jerry";
setcookie($cookie_name, $cookie_value, time() + (86400 * 30)); // 86400 = 1 day

?>

<html>
<body>
<?php
if(!isset($_COOKIE["user"])) {
    echo "Cookie named '" . "user" . "' is not set!";
} else {
    echo "Cookie '" . "user" . "' is set!<br>";
    echo "Value is: " . $_COOKIE["user"];
}
?>
</body>
</html>