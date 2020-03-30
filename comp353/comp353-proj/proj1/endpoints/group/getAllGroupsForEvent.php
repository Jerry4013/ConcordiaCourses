<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';
// include '../../endpoints/shared/authChecker.php';

//endpoint used to get all groups for an event

if ($_SERVER['REQUEST_METHOD'] === 'GET') {

    $eventID = $_GET["eventID"];

    $manager = new DBManager();
    $repo = new GroupRepo($manager);
    $groups = $repo->getAllGroupsForEvent($eventID);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($groups);
}
?>