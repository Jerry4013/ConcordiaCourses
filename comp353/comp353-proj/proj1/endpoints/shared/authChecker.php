<?php

    $token = getallheaders()['X-Auth-Token'];
    $user = getallheaders()['User'];

    if($_SERVER['REQUEST_METHOD'] !== 'OPTIONS'){
        $manager = new DBManager();
        $res = $manager->execute("SELECT * FROM session_token where user = '$user' and token = '$token'");
    
        if(sizeof($res) == 0){
            header("Access-Control-Allow-Origin: *");
            header("HTTP/1.1 301 Not Authenticarted");
            exit();
        }
    }
?>