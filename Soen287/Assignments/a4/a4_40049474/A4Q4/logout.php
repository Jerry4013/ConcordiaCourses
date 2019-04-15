<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-11-29
 * Time: 9:31 AM
 */
require "header.php";
if (!empty($_POST)){
    if ($_POST["submit"] == "Yes"){
        $_SESSION["login"] = False;
        $_SESSION["username"] = "";
        $_SESSION["password"] = "";
        echo "<script>location.href = 'home.php';</script>";
    } elseif ($_POST["submit"] == "No"){
        echo "<script>location.href = 'home.php';</script>";
    }
}

?>
<div class='confirmUI'>
    <h3>Are you sure log out your current account <?php echo $_SESSION["username"];?>?</h3>
    <form action="" method="post">
        <input type="submit" name="submit" value="Yes">
        <input type="submit" name="submit" value="No">
    </form>
</div>

<?php
require "footer.php";
?>