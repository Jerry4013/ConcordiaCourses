<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';


//endpoint used to create a new event (note: event manager must have already been added to the event manager table)

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $data = json_decode(file_get_contents('php://input'), true);
    
    $manager = new DBManager();
    $repo = new EventRepo($manager);
    
    $id = $repo->createEvent($data);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');

    if($id == 0){
        header("HTTP/1.1 401 Bad Request");
        echo json_encode("Invalid Event Data");
        exit();
    }

    $data['id'] = $id;

    echo json_encode($data);
}