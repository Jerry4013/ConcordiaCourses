<?php

include '../../modules/repositories/PostRepo.php';
include '../../modules/repositories/CommentRepo.php';
include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';


//given a postID this endpoint will give the post's details (and post author's details) and comments

if ($_SERVER['REQUEST_METHOD'] === 'GET') {
     
    $postID = $_GET["postID"];

    $manager = new DBManager();
    $repo = new PostRepo($manager);
    $post = $repo->getPost($postID);

	$commentRepo = new CommentRepo($manager);
    $comments = $commentRepo->getAllCommentsForPost($postID);

	$userRepo = new UserRepo($manager);
    $author = $userRepo->getUser($post->authorEmail);

	$data = array();

	$data['postDetails'] = $post;
	$data['postAuthorDetails'] = $author;
	$data['comments'] = $comments;

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');

    echo json_encode($data);
}
?>