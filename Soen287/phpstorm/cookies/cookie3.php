<?php
//$_COOKIE["numOfVisits"]=0;
$count= $_COOKIE["numOfVisits"]+1;
$length=time()+3600*24*365; // a year
setcookie("numOfVisits", $count, $length);