<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';


//endpoint used to remove a user from an event

if ($_SERVER['REQUEST_METHOD'] === 'DELETE') {
     
    $email = $_GET["user"];
    $eventID = $_GET["eventID"];
    
    $repo = new EventRepo(new DBManager());
    $repo->removeUserFromEvent($email, $eventID);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');

    echo json_encode("OK");
}