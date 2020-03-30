
<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';
// include '../../endpoints/shared/authChecker.php';

//endpoint used to get list of groups a user is in.

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $userID = $_GET["email"];
    $manager = new DBManager();
    $repo = new GroupRepo($manager);
    $groups = $repo->getGroupForUser($userID);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($groups);
}
?>