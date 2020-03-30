<?php
    include '../../modules/repositories/ChatRepo.php';
    include '../../endpoints/shared/corsHandler.php';
    include '../../endpoints/shared/authChecker.php';
    
    if ($_SERVER['REQUEST_METHOD'] === 'POST') {
        $data = json_decode(file_get_contents('php://input'), true);

        $sender = $data["sender"];
        $receipient = $data["receipient"];
        $sentTime = $data["sentTime"];

        $repo = new ChatRepo();
        $res = $repo->createChat($sender, $receipient, $sentTime);

        header('Content-type: application/json');
        header("Access-Control-Allow-Origin: *");

        switch($res){
            case 404:
                header("HTTP/1.1 404 Not Found");
                echo json_encode("user not found");
            break;
            case 401:
                header("HTTP/1.1 401 Bad Request");
                echo json_encode("chat already exists");
            break;
            default:
                header("HTTP/1.1 201 Created");
                echo json_encode($res);
            break;
        }
    }
?>