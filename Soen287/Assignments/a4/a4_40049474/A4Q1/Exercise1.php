<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exercise 1</title>
    <style>
        .output{
            color: red;
        }
    </style>
</head>
<body>
<form action="" method="post">
    <h1>Function 1: Summation</h1>
    <p>Please type a positive integer value, and press Submit:</p>
    <input type="number" name="f1">
    <input type="submit" name="f1submit" value="Submit"></br>
    <?php
    function findSummation($N = 1){
        if (is_nan($N) || $N <= 0){
            return false;
        }
        $sum = 0;
        $count = 1;
        while ($count <= $N){
            $sum += $count;
            $count++;
        }
        return $sum;
    }
    if (isset($_POST["f1submit"]) && $_POST["f1"]!=""){
        $sum = findSummation($_POST["f1"]);
        if (!$sum){
            echo "<p class='output'>Please enter a positive integer.</p>";
        } else {
            echo "<p class='output'>The Summation of the first {$_POST["f1"]} positive integers is: $sum </p>";
        }
    }
    ?>

    <h1>Function 2: Capitalization & Sort</h1>
    <p>Please type a string value, and press Submit:</p>
    <input type="text" name="f2">
    <input type="submit" name="f2submit" value="Submit"></br>
    <?php
    function uppercaseFirstandLastSorted($str){
        $arr = preg_split("/ /", $str);
        foreach ($arr as $key => $word) {
            $arr[$key] = strrev(ucfirst(strrev(ucfirst($word))));
        }
        sort($arr);
        return implode(" ", $arr);
    }

    if (isset($_POST["f2submit"]) && $_POST["f2"]!=""){
        echo "<p>The original String is: {$_POST["f2"]} </p>";
        $newString = uppercaseFirstandLastSorted($_POST["f2"]);
        echo "The new String is: <p class='output'>$newString </p>";
    }
    ?>

    <h1>Function 3: Average and Median</h1>
    <?php
    function findAverage_and_Median($numbers){
        $result = array();
        $count = count($numbers);
        $result["average"] = array_sum($numbers) / $count;
        sort($numbers);
        if ($count % 2 == 1){
            $median = $numbers[($count - 1) / 2];
        } else {
            $median = ($numbers[$count / 2] + $numbers[$count / 2 - 1]) / 2;
        }
        $result["median"] = $median;
        return $result;
    }
    $numbers = array(6, 7, 3, 8, 4, 1);
    echo "The array is: ", implode(" ", $numbers), "<br />";
    $result = findAverage_and_Median($numbers);
    echo "The Average is: ", $result["average"], "<br />";
    echo "The Median is: ", $result["median"], "<br />";
    ?>

    <h1>Function 4: first 4 Digits</h1>
    <p>Please enter integers, with spaces between each integer:</p>
    <input type="text" name="f4">
    <input type="submit" name="f4submit" value="Submit"></br>
    <?php
    function find4Digits($str){
        $numbers = preg_split("/ +/", $str);
        foreach ($numbers as $number){
            if (is_numeric($number) && strlen($number) == 4){
                return $number;
            }
        }
        return false;
    }

    if (isset($_POST["f4submit"]) && $_POST["f4"]!=""){
        echo "<p>The list of numbers is: {$_POST["f4"]} </p>";
        $result = find4Digits($_POST["f4"]);
        if ($result != 0){
            echo "<p class='output'>The first four-digit number in the string is: $result</p>";
        } else {
            echo "<p class='output'>There is no four-digit number in the string.</p>";
        }
    }
    ?>
</form>

</body>
</html>


