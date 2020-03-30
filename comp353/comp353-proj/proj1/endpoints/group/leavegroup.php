
<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';
include '../../endpoints/shared/corsHandler.php';
// include '../../endpoints/shared/authChecker.php';

// Endpoint used to remove a user from a group

if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $email = $_POST['email'];
    $groupWantingToLeave = $_POST['groupId'];

    $manager = new DBManager();
    $repo = new GroupRepo($manager);
    $repo->leaveGroup($groupWantingToLeave, $email);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    
    $msg = "Delete Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>