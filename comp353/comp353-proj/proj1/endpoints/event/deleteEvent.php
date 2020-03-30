<?php

include '../../modules/repositories/EventRepo.php';
include '../../modules/DBManager.php';
include '../../endpoints/shared/corsHandler.php';

if ($_SERVER['REQUEST_METHOD'] === 'DELETE') {

    $id = $_GET['id'];

    $manager = new DBManager();
    $repo = new EventRepo($manager);
    $res = $repo->deleteEvent($id);

    header('Content-type: application/json');
    header('Access-Control-Allow-Origin: *');
    echo json_encode('ok');
}
?>