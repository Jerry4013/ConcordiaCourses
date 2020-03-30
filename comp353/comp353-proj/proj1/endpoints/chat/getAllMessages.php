<?php
    include '../../modules/repositories/ChatRepo.php';
    include '../../modules/repositories/models/chat-state.php';
    include '../../endpoints/shared/corsHandler.php';
    // include '../../endpoints/shared/authChecker.php';

    if ($_SERVER['REQUEST_METHOD'] === 'GET') {
        
        $repo = new ChatRepo();

        $tables = $repo->getChatMessages($_GET["chatID"]);

        header('Content-type: application/json');
        header("Access-Control-Allow-Origin: *");

        echo json_encode($tables);
    }
?>