<?php

include 'models/Comment.php';

class CommentRepo {
	
	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}

	public function commentOnPost($comment){
        $q = "INSERT INTO t_comment(content, p_date, postID, author_email)
              VALUES (?,?,?,?);"; 

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, $comment->content);
        $stmt -> bindValue(2, $comment->date);
        $stmt -> bindValue(3, $comment->postID);
        $stmt -> bindValue(4, $comment->authorEmail);
		$stmt -> execute();
        return $stmt;
	}
	
	public function getAllCommentsForPost($postID){
		
		$q = "SELECT * FROM t_comment where postID = " . $postID;
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbPost = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $postComments = array();

        for($i = 0; $i < count($dbPost); $i++){
            $arrEntry = $dbPost[$i];
            
            array_push($postComments, new Comment(
                $arrEntry["ID"],
                $arrEntry["postID"],
                $arrEntry["content"],
                $arrEntry["p_date"],
                $arrEntry["author_email"]
            ));
        }
        return $postComments;
	}
}