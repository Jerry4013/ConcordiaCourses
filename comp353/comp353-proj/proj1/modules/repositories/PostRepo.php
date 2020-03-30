<?php

include 'models/Post.php';

class PostRepo {

    //Interface info
    //addPostToGroup($post)
    //getAllPostsForGroup($groupId)
	
	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}

	public function addPostToGroup($post){
		
        $q = "INSERT INTO t_post(url, content, p_date, isCommentable, isPublic, groupID, author_email)
              VALUES (?,?,?,?,?,?, ?);"; 

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, $post->url);
		$stmt->bindValue(2, $post->content);
        $stmt -> bindValue(3, $post->date);
        $stmt -> bindValue(4, $post->isCommentable);
        $stmt -> bindValue(5, $post->isPublic);
        $stmt -> bindValue(6, $post->groupId);
        $stmt -> bindValue(7, $post->authorEmail);
		$stmt -> execute();
        return $stmt;
	}

    public function getAllPostsForGroup($groupId){

        $q = "SELECT * FROM t_post where groupID = " . $groupId;
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbPost = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $groupPosts = array();

        for($i = 0; $i < count($dbPost); $i++){
            $arrEntry = $dbPost[$i];
            
            array_push($groupPosts, new Post(
                $arrEntry["ID"],
                $arrEntry["url"],
                $arrEntry["content"],
                $arrEntry["p_date"],
                $arrEntry["isCommentable"],
                $arrEntry["isPublic"],
                $arrEntry["groupID"],
                $arrEntry["author_email"]
            ));
        }
        return $groupPosts;
    }
	
	public function getPost($postID){

        $q = "SELECT * FROM t_post where ID = " . $postID;
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbPost = $stmt->fetchAll(PDO::FETCH_ASSOC);      

        for($i = 0; $i < count($dbPost); $i++){
            $arrEntry = $dbPost[$i];
            
			$post = new Post(
                $arrEntry["ID"],
                $arrEntry["url"],
                $arrEntry["content"],
                $arrEntry["p_date"],
                $arrEntry["isCommentable"],
                $arrEntry["isPublic"],
                $arrEntry["groupID"],
                $arrEntry["author_email"]
            );
        }
        return $post;
    }
}
?>