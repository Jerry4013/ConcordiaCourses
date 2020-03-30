<?php

include '../../modules/repositories/EmailRepo.php';
include '../../modules/DBManager.php';


// endpoint used to get list of emails by a specific recipient.

if ($_SERVER['REQUEST_METHOD'] === 'GET') {

    $recipient = $_GET["recipient"];

    $manager = new DBManager();
    $repo = new EmailRepo($manager);
    $emails = $repo->getAllEmailsByRecipient($recipient);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($emails);
}