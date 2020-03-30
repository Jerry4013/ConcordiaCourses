<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';


//endpoint used to get list of users (and their information) who are members of a specific event. 

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $eventID = $_GET["eventID"];

    $manager = new DBManager();
    $repo = new UserRepo($manager);
    $users = $repo->getAllUsersForEvent($eventID);

    header('Content-type: application/json');
    echo json_encode($users);
}
?>