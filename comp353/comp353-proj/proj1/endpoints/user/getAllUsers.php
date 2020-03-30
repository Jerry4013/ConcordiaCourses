<?php

include '../../modules/repositories/UserRepo.php';
include '../../modules/DBManager.php';


//endpoint used to get list of users (and their information) who are members of a specific event. 

if ($_SERVER['REQUEST_METHOD'] === 'GET') {

    $manager = new DBManager();
    $repo = new UserRepo($manager);
    $users = $repo->getAllUsers();

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode($users);
}
?>