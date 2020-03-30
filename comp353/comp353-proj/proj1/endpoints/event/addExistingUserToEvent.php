<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';

//endpoint used to add an already existing user to an event

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $email = $_GET["user"];
    $eventID = $_GET["eventID"];
    
    $manager = new DBManager();
    $repo = new EventRepo($manager);
    $res = $repo->addExistingUserToEvent($email, $eventID);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');

    if($res){
        header("HTTP/1.1 201 Created");
        echo json_encode($res);
    }else{
        header("HTTP/1.1 401 Bad Request");
        echo json_encode("User already added");
    }
}