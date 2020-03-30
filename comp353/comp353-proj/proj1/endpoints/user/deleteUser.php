<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


// Endpoint used to delete a user


if ($_SERVER['REQUEST_METHOD'] === 'POST') {

    $email = $_POST['email'];

    $manager = new DBManager();
    $repo = new UserRepo($manager);
    $repo->deleteUser($email);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}
?>