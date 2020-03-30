<?php

    include '../../modules/repositories/ChatRepo.php';
    include '../../modules/repositories/models/chat-state.php';
    include '../../endpoints/shared/corsHandler.php';

    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        
        include '../../endpoints/shared/authChecker.php';

        $data = json_decode(file_get_contents('php://input'), true);

        $sender = $data["sender"];
        $receipient = $data["receipient"];
        $content = $data["content"];
        $sentTime = $data["sentTime"];

        $chatID = $_GET["chatID"];

        $message = new ChatMessage(null, $sender, $receipient,$content,$sentTime);

        $repo = new ChatRepo();
        $id = $repo->postMessage($chatID ,$message);
        $message->mID = $id;

        header('Content-type: application/json');
        header("Access-Control-Allow-Origin: *");

        echo json_encode($message);
    }
?>