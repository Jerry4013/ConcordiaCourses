<?php

include '../../modules/repositories/EmailRepo.php';
include '../../modules/DBManager.php';


// endpoint used to get list of emails by a specific sender.

if ($_SERVER['REQUEST_METHOD'] === 'GET') {

    $sender = $_GET["sender"];

    $manager = new DBManager();
    $repo = new EmailRepo($manager);
    $emails = $repo->getAllEmailsBySender($sender);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($emails);
}