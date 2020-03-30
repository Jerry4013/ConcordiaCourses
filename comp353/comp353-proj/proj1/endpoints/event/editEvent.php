<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';

//endpoint used to edit an event

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $data = json_decode(file_get_contents('php://input'), true);

    $manager = new DBManager();
    $repo = new EventRepo($manager);
    $repo->editEvent($data);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');

    echo json_encode("ok");
}