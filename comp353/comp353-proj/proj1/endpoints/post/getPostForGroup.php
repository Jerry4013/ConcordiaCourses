
<?php

include '../../modules/repositories/PostRepo.php';
include '../../modules/DBManager.php';


//endpoint used to get list of post for a specific group. 

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $groupId = $_GET["groupId"];

    $manager = new DBManager();
    $repo = new PostRepo($manager);
    $groups = $repo->getAllPostsForGroup($groupId);
    
    header('Access-Control-Allow-Origin: *');
    header('Content-type: application/json');
    echo json_encode($groups);
}
?>