
<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';
include '../../endpoints/shared/corsHandler.php';
// include '../../endpoints/shared/authChecker.php';

// Endpoint used to send a join request for a group


if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $userID = $_POST['email'];
    $groupWantingToJoin = $_POST['groupId'];

    $manager = new DBManager();
    $repo = new GroupRepo($manager);
    $repo->requestJoinGroup($groupWantingToJoin, $userID);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>