<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-11-15
 * Time: 10:21 AM
 */

function splitter($str){
    preg_match_all("/\w+'*\w*/u", $str, $matches);
    return $matches;
}

$str = "apples. are, good? for, you, or, don't? you, like? apples, or. maybe. you, like,
oranges, better. than. apples?";
$matches = splitter($str);
foreach ($matches[0] as $word){
    print "The words are: $word <br/>";
}

$freq = array();
foreach ($matches[0] as $word){
    preg_match("/\w+'*\w*/u", $str, $match);
}