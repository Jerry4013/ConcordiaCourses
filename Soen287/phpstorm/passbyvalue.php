<?php
/**
 * Created by PhpStorm.
 * User: owner
 * Date: 2018-11-08
 * Time: 11:13 AM
 */

$name="John Smith";
if(preg_match("/^J/",$name))
    echo $name," begins with J";
else
    echo $name," does not begins with J";
print "<br />";
function f($a1, &$a2, &$a3){
    foreach ($a1 as $temp){
        if ($temp > 0){
            $a2[] = $temp;
        } elseif ($temp < 0) {
            $a3[] = $temp;
        }
    }
}

$a1 = array(2, 3, -1, 4, -3, 8);
$a2 = array();
$a3 = array();

f($a1, $a2, $a3);
print_r($a2);
print "<br />";
print "<br />";
print_r($a3);
print_r($a3);