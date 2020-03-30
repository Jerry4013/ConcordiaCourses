<?php

include '../../modules/DBManager.php';
include '../../modules/repositories/models/chatMessage.php';

class ChatRepo {
	
	private $db = null;
   
    public function __construct() {
        $this->db = new DBManager(); 
    }
    
    public function getAllChats($username){
        $q = "SELECT cID,lastMessageID,sender,receipient,content,sentTime
        FROM user_chat
        NATURAL JOIN chats
        NATURAL JOIN chat_messages
        WHERE user = " . $username . " AND lastMessageID = mID";

        $res = $this->db->execute($q);

        return $res;
    }

    public function getChatMessages($chatId){
        $q = "SELECT mID,sender,receipient,content,sentTime
        FROM chat_messages
        WHERE chatID=".$chatId;

        $res = $this->db->execute($q);
        return $res;
    }

    public function postMessage($chatID, $message){
        $q = "INSERT INTO chat_messages(chatID,sender,receipient,content,sentTime)
        VALUES (?,?,?,?,?);"; 

        $pdo = $this->db->getHandle();
        $stmt = $pdo->prepare($q);
        $stmt->bindValue(1, $chatID);
        $stmt -> bindValue(2, $message->sender);
        $stmt -> bindValue(3, $message->receipient);
        $stmt -> bindValue(4, $message->content);
        $stmt -> bindValue(5, $message->sentTime);
        $stmt -> execute();

        $messageID = $this->db->getHandle()->lastInsertId();

        $q = "UPDATE chats SET lastMessageID = '$messageID' WHERE cID = '$chatID'";
        $stmt = $pdo->prepare($q);
        $stmt -> execute();

        return $messageID;
    }

    public function createChat($sender, $receipient, $sentTime){
        $q = "SELECT COUNT(*) 
        FROM user_chat a 
        join user_chat b on a.cID = b.cID and a.user < b.user and a.user in ('$sender','$receipient') and b.user in ('$sender','$receipient')";

        $res = $this->db->execute($q);

        if($res[0]['COUNT(*)'] >= 1 ) return 401;

        $res = $this->db->execute('INSERT INTO chats VALUES(null, null)');
        $chatID = $this->db->getHandle()->lastInsertId();

        try{
            $res = $this->db->execute("INSERT INTO user_chat VALUES('$sender','$chatID')");
            $res = $this->db->execute("INSERT INTO user_chat VALUES('$receipient','$chatID')");
        }catch(Error $e){
            return 404;
        }

        $content = $sender.' said Hi!';
        $message = new ChatMessage($chatID, $sender,$receipient, $content, $sentTime);

        $this->postMessage($chatID, $message);

        return $message;
    }
}