<?php

include '../../modules/repositories/EmailRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $title = $_POST["title"];
    $sender = $_POST["sender"];
    $recipient = $_POST["recipient"];
    $content = $_POST["content"];


    $email = new Email(0, $title, $sender, $recipient, $content);
    
    $manager = new DBManager();
    $repo = new EmailRepo($manager);
    $repo->createEmail($email);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}