<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>Telephone Number Validation</title>
    <style>
        body{background-color: #ddeeff;margin: 50px;}
        .warning{color: red; font-weight: bold;}
        .inform{color: green; font-weight: bold;}
    </style>
</head>
<body>
<h1>Information</h1>
<form method="post" action="">
    <label>Name: <input name="name" size="25" /></label>
    <br /><br />
    <label>Telephone(ddd-ddd-dddd): <input type="text" name="telephone" size="25" /></label>
    <br /><br />
    <?php
    if (isset($_POST['submit'])){
        if (empty($_POST['name']) || empty($_POST['telephone'])) {
            echo "<p class='warning'>Sorry, the form is incomplete.</p>";
            echo "<p class='warning'>Please fill all the required entries. Thank you.</p>";
        } elseif (preg_match("/^\d{3}-\d{3}-\d{4}$/",trim($_POST['telephone'])) == 1){
            echo "<p class='inform'>We have saved your telephone number. {$_POST['telephone']}</p>";
        } else {
            echo "<p class='warning'> The format of your telephone number is invalid. Please type again.</p>";
        }
    }
    ?>
    <input type="submit" name="submit" value="Submit" />
    <input type="reset" value="Clear" />
</form>

</body>
</html>