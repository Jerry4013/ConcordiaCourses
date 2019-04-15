<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exercise 1</title>
    <style>
        #time{
            font-weight: bold;
            font-style: italic;
            font-size: large;
        }
        body{
            background-color: #def;
            margin: 50px;
        }
    </style>
</head>
<body>
<?php
date_default_timezone_set("America/Montreal");
$length = time() + 3600*24*365;
if (isset($_COOKIE["numOfVisits"])){
    $count = $_COOKIE["numOfVisits"] + 1;
    echo "<h1>Hello, this is the $count time that you are visiting my web page.</h1>";
    echo "<p id='time'>Last time you visited my web page on:".
        date("D F d H:i:s T Y", $_COOKIE["lastVisitTime"])."</p>
        <p>(EST= Eastern Standard Time Zone)</p>";
} else {
    $count = 1;
    echo "<h1>Welcome to my web page! It is your first time that you are here.</h1>";
}
setcookie("numOfVisits", $count, $length);
setcookie("lastVisitTime", time(), $length);
?>
</body>
</html>

