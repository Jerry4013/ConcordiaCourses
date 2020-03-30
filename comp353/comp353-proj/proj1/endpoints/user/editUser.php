<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';
include '../response/Response.php';


//endpoint used to edit a user

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
     
    $email = $_POST["email"];
    $password = $_POST["password"];
    $role = $_POST["role"];
    $birthDate = $_POST["birthDate"];
    $name = $_POST["name"];
    $address = $_POST["address"];
    $phone = $_POST["phone"];
    $organization = $_POST["organization"];

	//needed to convert empty string to null
	if($role == '')
		$role = null;
	if($birthDate == '')
		$birthDate = null;

    $user = new User($email, $password, $role, $birthDate, $name, $address, $phone, $organization);
    
    $manager = new DBManager();
    $repo = new UserRepo($manager);
    $repo->editUser($user);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    $msg = "Operation Complete";
    echo json_encode(new Response(true, $msg));
}