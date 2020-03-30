<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';


//endpoint used to get list of events that a user is a member of

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $email = $_GET["email"];

    $manager = new DBManager();
    $repo = new EventRepo($manager);
    $events = $repo->getAllEventsForUser($email);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($events);
}
?>