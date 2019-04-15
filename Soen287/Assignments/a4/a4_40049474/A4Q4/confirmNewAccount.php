<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-11-28
 * Time: 11:46 PM
 */
require "header.php";

if (!empty($_POST)){
    if(!empty($_POST['submit']) && $_POST['submit'] == "Confirm") {
        $file = fopen("login.txt","a+");
        fwrite($file, "{$_SESSION["username"]}:{$_SESSION["password"]}\n");
        fclose($file);
        $_SESSION["login"] = True;
        echo "<script>location.href = 'home.php';</script>";
    } elseif(!empty($_POST['submit']) && $_POST['submit'] == "Reset"){
        $_SESSION["username"] = "";
        $_SESSION["password"] = "";
        echo "<script>location.href = 'login.php';</script>";
    }
}
?>

<div class='confirmUI'>
    <h2>User name does not exit. Do you want to create a new account?</h2>
    <form action="" method="post">
        <h2>Username: <?php echo $_SESSION["username"];?></h2>
        <h2>Password: <?php echo $_SESSION["password"];?></h2>
        <input type="submit" name="submit" value="Confirm">
        <input type="submit" name="submit" value="Reset">
    </form>
</div>

<?php
require "footer.php";
?>