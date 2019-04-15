<?php
session_start();
if (empty($_SESSION)) {
    $_SESSION["login"] = False;
    $_SESSION["username"] = "";
    $_SESSION["password"] = "";
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="Author" content="Jingchao Zhang"/>
    <title>Cottage Search</title>
    <link rel="stylesheet" type="text/css" href="mystyle.css">
    <script src="myscript.js"></script>
</head>
<body>
<?php
if ($_SESSION["login"] == False) {
    ?>
    <div class="loginButton">
        <button type="button" class="button" onclick="login()">Login</button>
    </div>
    <?php
} elseif ($_SESSION["login"] == True) {
    ?>
    <div class="loginButton">
        <span class='welcome'>Welcome, <?php echo $_SESSION["username"]?>!</span>
        <button type="button" class="button" onclick="logout()">Logout</button>
    </div>
    <?php
}
?>

<table class="headerTable">
    <tr align="center">
        <td align="left"><a href="home.php">
                <img src="for-rent-house.jpg"
                     alt="Cannot find the image" height="150" width="200"></a>
        </td>
        <td><h1>Cottage Search Form</h1></td>
        <td align="right"><p id="clock"></p></td>
    </tr>
</table>
<script> clock();</script>