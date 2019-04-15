<?php
/**
 * Created by PhpStorm.
 * User: owner
 * Date: 2018-11-13
 * Time: 10:54 AM
 */

function display($numbers){
    $unique = array();
    foreach ($numbers as $number){
        if (!in_array($number, $unique)){
            array_push($unique,$number);
        }
    }
    return $unique;
}

$numbers = [42, 24, 2, 4, 42, 24];
$unique = array_unique($numbers);
foreach ($unique as $number)
    print "$number<br />";

