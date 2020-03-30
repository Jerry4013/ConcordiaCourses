<?php

include '../../modules/repositories/CommentRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


//endpoint used to add a comment to a specific post by a user

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $content = $_POST["content"];
    $postID = $_POST["postID"];
    $authorEmail = $_POST["authorEmail"];
    $date =  date("Y-m-d"); 

    $comment = new Comment(0, $postID, $content, $date, $authorEmail);
    
    $manager = new DBManager();
    $repo = new CommentRepo($manager);
    $repo->commentOnPost($comment);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>