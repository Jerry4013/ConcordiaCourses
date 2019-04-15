<?php
/**
 * Created by PhpStorm.
 * User: owner
 * Date: 2018-11-28
 * Time: 11:54 AM
 */

require "header.php";
$valid = True;
$file = NULL;
$found = False;
$pair = array();
if (!empty($_POST)){
    $file = fopen("login.txt","a+");
    if ($file) {
        while (($buffer = fgets($file, 4096)) !== false) {
            $pair = preg_split("/:/", $buffer) ;
            if ($pair[0] == $_POST['name']){
                $found = True;
                if (trim($pair[1]) == trim($_POST['password'])){
                    $_SESSION["login"] = True;
                    $_SESSION["username"] = $_POST['name'];
                    $_SESSION["password"] = $_POST['password'];
                    echo "<script>location.href = 'home.php';</script>";
                } else {
                    $valid = False;
                }
            }
        }
        if (!feof($file)) {
            echo "Error: unexpected fgets() fail\n";
        }
        fclose($file);
        if ($found == False){
            $_SESSION["username"] = $_POST['name'];
            $_SESSION["password"] = $_POST['password'];
            echo "<script>location.href = 'confirmNewAccount.php';</script>";
        }

    }
}
?>
<div class="loginUI">
    <form id="loginForm" class="loginForm" method="post" onsubmit="return formatCheck()" action="">
        <table class="loginTable">
            <col width="10">
            <col width="80">
            <col width="200">
            <tr>
                <td height="30" class="star" id="usernameStar">*</td>
                <td height="30"><label for="name">Username:</label></td>
                <td height="30"><input id="name" type="text" name="name"></td>
            </tr>
            <tr>
                <td height="30" class="star" id="passwordStar">*</td>
                <td height="30"><label for="password">Password:</label></td>
                <td height="30"><input id="password" type="password" name="password"></td>
            </tr>
        </table>
        <h3 class="hint">
            Note: <span id="usernameHint">A username can contain letters (both upper and lower case) and
                digits only. No space.</span><br />
            <span id="passwordHint">A password must be at least 6 characters long (letters and digits only), <br />
            have at least one letter and at least one digit.</span><br /><br />
            <?php
            if (!$valid){
                echo "<p id='invalidHint'>Invalid login! Your password is incorrect. Please try again.</p>";
            }
            ?>
        </h3>
        <div class="submitButtons">
            <input type="submit" value="Login">&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="reset" value="Clear">
        </div>
        <script>
            document.getElementById("name").onblur = checkName;
            document.getElementById("password").onblur = checkPassword;
            document.getElementById("loginForm").onsubmit = formatCheck;
        </script>
    </form>
</div>

<?php
require "footer.php";
?>