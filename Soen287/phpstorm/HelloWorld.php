<?php
$output = "<p>Hello World!</p>";
function hello1() {
    global $output;
    print $output;
}
function hello2() {
//    print $output;
}
hello1();
hello2();


