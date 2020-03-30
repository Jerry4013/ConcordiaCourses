
<?php

include '../../modules/repositories/GroupRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


// Endpoint used to send a join request for a group
if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $userID = $_POST['email'];
    $forEvent = $_POST['eventId'];
    $groupTitle = $_POST['title']; 

    $manager = new DBManager();
    $repo = new GroupRepo($manager);

    $newGroupID = $repo->addGroup($forEvent, $userID, $groupTitle);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>