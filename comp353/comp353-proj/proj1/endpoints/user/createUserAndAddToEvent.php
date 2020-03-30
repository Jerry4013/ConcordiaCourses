<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


//endpoint used to create a new user and add them to an existing event

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $email = $_POST["email"];
    $password = $_POST["password"];
    $role = $_POST["role"];
    $birthDate = $_POST["birthDate"];
    $name = $_POST["name"];
    $address = $_POST["address"];
    $phone = $_POST["phone"];
    $organization = $_POST["organization"];
	$eventID = $_POST["eventID"];
	
	//needed to convert empty string to null
	if($role == '')
		$role = null;
	if($birthDate == '')
		$birthDate = null;

    $user = new User($email, $password, $role, $birthDate, $name, $address, $phone, $organization);
    
    $manager = new DBManager();
    $userRepo = new UserRepo($manager);
    $userRepo->createUser($user);
	$eventRepo = new EventRepo($manager);
    $eventRepo->addExistingUserToEvent($email, $eventID);

    header('Content-type: application/json');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}