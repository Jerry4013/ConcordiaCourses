



<?php

include '../../modules/repositories/PostRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';



//endpoint used to add a specific post to a group by a user

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $url = $_POST["url"];
    $content = $_POST["content"];

    $isCom = ($_POST["commentable"] === 'true' ? 1 : 0);
    $isPub = ($_POST["public"] === 'true' ? 1 : 0);
    $date =  date("Y-m-d"); 
    $userId = $_POST["userId"];
    $groupId = $_POST["groupId"];

    $post = new Post(0, $url, $content, $date, $isCom, $isPub, $groupId, $userId);
    
    $manager = new DBManager();
    $repo = new PostRepo($manager);
    $repo->addPostToGroup($post);

    header('Access-Control-Allow-Origin: *');
    header('Content-type: application/json');
    
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>