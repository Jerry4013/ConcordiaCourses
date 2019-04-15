<?php
if (isset($_COOKIE["numOfVisits"])){
    echo $_COOKIE["numOfVisits"];
}

// set the expiration date to one hour ago
setcookie("numOfVisits", "", time() - 3600);
