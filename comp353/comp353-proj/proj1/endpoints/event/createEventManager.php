<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


//endpoint used to create a new event manager (note that user must be created before making that user an event manager)

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $email = $_POST["email"];
    $accountNo = $_POST["accountNo"];
    $bankName = $_POST["bankName"];
    $bankAddress = $_POST["bankAddress"];

    $eventManager = new EventManager(0, $email, $accountNo, $bankName, $bankAddress);
    
    $manager = new DBManager();
    $repo = new EventRepo($manager);
    $repo->createEventManager($eventManager);

    header('Content-type: application/json');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}