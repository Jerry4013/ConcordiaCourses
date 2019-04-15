<?php
/**
 * Created by PhpStorm.
 * User: owner
 * Date: 2018-11-13
 * Time: 10:41 AM
 */

function splitter($str){
    $freq = array();
    $words = preg_split("/[ .,;:!?]\s/", $str);
    foreach ($words as $word) {
        echo "$word <br/>";
    }

}

$str = "Apples are good";
splitter($str);