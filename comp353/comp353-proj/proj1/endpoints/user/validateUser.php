<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';
include '../../endpoints/shared/tokenGenerator.php';

//endpoint used to validate login credentials. if credentials match a user in the database that user will be returned else false. 

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    
    $data = json_decode(file_get_contents('php://input'), true);

    $email = $data["email"];
	$password = $data["password"];

    $manager = new DBManager();
    $repo = new UserRepo($manager);
    $user = $repo->validateUser($email, $password);

    header('Content-type: application/json');
    header("Access-Control-Allow-Origin: *");

    if(!$user){
        header("HTTP/1.1 301 Not Authorized");
        echo json_encode("Invalid Credentials");
    }else{
        $token = Token::generate();
        $user->token = $token;
        $manager->execute("INSERT into session_token values('$email', '$token') ON DUPLICATE KEY UPDATE token = '$token'");

        echo json_encode($user);
    }
}
?>