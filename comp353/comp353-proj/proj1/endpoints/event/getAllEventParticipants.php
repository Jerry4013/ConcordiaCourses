<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $eventID = $_GET["eventID"];

    $repo = new EventRepo(new DBManager());

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($repo->getAllParticipants($eventID));
}
