<!DOCTYPE html>
<html lang = "en">
<head>
    <title> animals </title>
    <meta charset = "utf-8" />
</head>
<body>

<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-12-05
 * Time: 6:58 PM
 */
$result = "";

if (isset($_POST["sides"])){
    $result = roll($_POST["sides"]);
}
function roll($sides){
    return rand(1, $sides);
}

?>
<h2>Die Roller!!!</h2>
<form action="" method="post">

    <label for="sides">Sides:</label>
    <input type="number" id="sides" name="sides", value="<?php echo @$_POST['sides'] ?>">
    <label>Result</label>
    <?php
    echo $result;
    ?>
    <input type="submit" value="roll">
</form>
</body>
</html>