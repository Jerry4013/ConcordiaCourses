<?php
/**
 * Created by PhpStorm.
 * User: JerryZhang
 * Date: 2018-11-16
 * Time: 10:34 AM
 */

$list = array(2, 4, 6, 8);
foreach ($list as $key => $value){
    echo $key,"=>",$value,"<br />";
}
unset($list[2]);
foreach ($list as $key => $value){
    echo $key,"=>",$value,"<br />";
}