<?php

include 'models/Email.php';

class EmailRepo {
	
	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}
	
	public function getAllEmailsByRecipient($recipient){
		$q = "SELECT * FROM t_email WHERE recipient = '" . $recipient . "';";
        return $this->getEmails($q);
	}

    public function getAllEmailsBySender($sender){
        $q = "SELECT * FROM t_email WHERE sender = '" . $sender . "';";
        return $this->getEmails($q);
    }

	private function getEmails($q) {
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);
        $dbEmails = $stmt->fetchAll(PDO::FETCH_ASSOC);
        $emails = array();

        for($i = 0; $i < count($dbEmails); $i++){
            $arrEntry = $dbEmails[$i];

            array_push($emails, new Email(
                $arrEntry['id'],
                $arrEntry['title'],
                $arrEntry['sender'],
                $arrEntry['recipient'],
                $arrEntry['content']));
        }
        return $emails;
    }

    public function createEmail($email) {
		$q = "INSERT INTO t_email (title, sender, recipient, content) VALUES (?,?,?,?);";

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
        $stmt -> bindValue(1, $email->title);
        $stmt -> bindValue(2, $email->sender);
        $stmt -> bindValue(3, $email->recipient);
        $stmt -> bindValue(4, $email->content);
		$stmt -> execute();
        return $stmt;
	}
	
	public function editEmail($email) {
        $q = "UPDATE t_email SET title = ?, sender = ?, recipient = ?, content = ? WHERE id = ?";
        $pdo = $this->db->getHandle();

		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $email->title);
		$stmt->bindParam(2, $email->sender);
		$stmt->bindParam(3, $email->recipient);
		$stmt->bindParam(4, $email->content);
		$stmt->bindParam(5, $email->id);
		$stmt -> execute();
        return $stmt;
	}
	
}