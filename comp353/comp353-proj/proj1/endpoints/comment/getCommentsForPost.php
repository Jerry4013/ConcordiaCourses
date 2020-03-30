<?php

include '../../modules/repositories/CommentRepo.php';
include '../../modules/DBManager.php';


//endpoint used to get all comments for a specific post. 

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $postID = $_GET["postID"];

    $manager = new DBManager();
    $repo = new CommentRepo($manager);
    $groups = $repo->getAllCommentsForPost($postID);

    header('Content-type: application/json');
    echo json_encode($groups);
}
?>