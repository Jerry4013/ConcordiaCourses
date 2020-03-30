


<?php

    include '../modules/DBManager.php';
    include '../modules/repositories/PostRepo.php';
    include '../modules/repositories/GroupRepo.php';

    $user = 'root';
    $passwd = ''; 
    $dbname = 'dbproject';
    $url = "mysql:host=localhost;dbname=";
    //$manager = new DBManager($url, $dbname, $user, $passwd);
    $manager = new DBManager();
    //$repo = new PostRepo($manager);//new GroupRepo($manager);


    // -------------- Test COde 


    $post_repo = new PostRepo($manager);
    $group_repo = new GroupRepo($manager);  


    $url = "https://image.shutterstock.com/image-photo/beautiful-water-drop-on-dandelion-260nw-789676552.jpg";
    $content = "Test making iwth post"
    $isCom = true;
    $isPub = false;
    $date =  '2011-01-01';
    $userId = $_POST["userId"];
    $groupId = $_POST["groupId"];

    $post = new Post(0, $url, $content, $date, $isCom, $isPub, $groupId, $userId);


    var_dump($post_repo->addPostToGroup('2'));
    




/*
    $userID = 781264;
    $groupWantingToJoin = 4; 
    $post = new Post(0, 'test', 'content', date("Y-m-d"), TRUE, TRUE, $groupWantingToJoin, $userID);
    $repo->addPostToGroup($post);
*/





    echo "DONE"; 


?>