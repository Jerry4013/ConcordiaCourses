<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';
// include '../../endpoints/shared/authChecker.php';

//endpoint used to get all groups that a user has requested to join

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $email = $_GET["email"];

    $manager = new DBManager();
    $repo = new GroupRepo($manager);
    $groups = $repo->getGroupsUserRequestedToJoin($email);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    
    echo json_encode($groups);
}
?>