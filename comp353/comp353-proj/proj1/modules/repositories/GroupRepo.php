<?php

include 'models/Group.php';

class GroupRepo {
	
    //interface info
    //addGroup($eId, $ownerEmail, $title) (tested)
    //editGroupTitle($group)
    //deleteGroup($group)
    //getGroup($id)
    //requestJoinGroup($groupId, $userEmail)
    //leaveGroup($groupId, $userEmail)
    //getGroupForUser($userEmail)

	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}

	public function addGroup($eId, $ownerEmail, $title){
		
        $q = "INSERT INTO t_group(eventID, owner_email, title)
                VALUES (?, ?, ?)";

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, $eId);
		$stmt->bindValue(2, $ownerEmail);
        $stmt -> bindValue(3, $title);
		$stmt -> execute();

        //put entry in t_user_groups
        $id = $pdo->lastInsertId();   
        $this->addUserToGroup($id, $ownerEmail);

        return $stmt;
	}

    public function editGroupTitle($group){
		
        $q = "UPDATE t_group SET title = ? WHERE groupID = ?"; 
        $pdo = $this->db->getHandle();
		
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $group->title);
		$stmt->bindParam(2, $group->groupId);
		$stmt -> execute();
        return $stmt;

	}

    public function deleteGroup($groupId){

        $q = "DELETE FROM t_group WHERE groupID = ?;";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $groupId);
        $stmt -> execute();
        return $stmt;	
	}

    public function getGroup($id){
        $q = "SELECT * FROM t_group WHERE groupID = " . $id . ";"; 
        
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'DBGroup');
        
        $dbGroup = $stmt->fetch();
        $group = new Group($dbGroup['groupID'], $dbGroup['eventID'], $dbGroup['owner_email'], $dbGroup['title']); 
		return $group;
	}

    //Custom Services
    //req #5
    public function requestJoinGroup($groupId, $userEmail){

        $q = "INSERT INTO t_group_requests VALUES (?,?);";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, (int)$groupId);
        $stmt->bindValue(2, $userEmail);
        $stmt -> execute();
        return $stmt;

    }

    //req #6
    public function leaveGroup($groupId, $userEmail){
        
        $q = "DELETE FROM t_user_group WHERE groupID = ? AND author_email = ?;";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $groupId);
        $stmt->bindParam(2, $userEmail);
        $stmt -> execute();
        return $stmt;
    }

    public function getGroupForUser($userEmail){

        $q = "SELECT * from t_group
                inner join t_user_group On t_user_group.author_email = t_group.owner_email
                where owner_email = " . "'$userEmail'";

        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbGroups = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $groups = array();

        for($i = 0; $i < count($dbGroups); $i++){
            $arrEntry = $dbGroups[$i];
            array_push($groups, new Group($arrEntry['groupID'], $arrEntry['eventID'], $arrEntry['owner_email'], $arrEntry['title']));
        }        
        return $groups;
    }
	
	public function getAllGroupsForEvent($eventID){

        $q = "SELECT * from t_group where eventID = $eventID";

        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbGroups = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $groups = array();

        for($i = 0; $i < count($dbGroups); $i++){
            $arrEntry = $dbGroups[$i];
            array_push($groups, new Group($arrEntry['groupID'], $arrEntry['eventID'], $arrEntry['owner_email'], $arrEntry['title']));
        }        
        return $groups;
    }

	public function getGroupsUserRequestedToJoin($email){

        $q = "SELECT * from t_group_requests 
				inner join t_group On t_group.groupID = t_group_requests.groupID
				where user_email = '$email'";

        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbGroups = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $groups = array();

        for($i = 0; $i < count($dbGroups); $i++){
            $arrEntry = $dbGroups[$i];
            array_push($groups, new Group($arrEntry['groupID'], $arrEntry['eventID'], $arrEntry['owner_email'], $arrEntry['title']));
        }        
        return $groups;
    }

    public function addUserToGroup($groupId, $ownerEmail){
        //put record in t_user_group
        $q = "insert into t_user_group values(?,?);";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $groupId);
        $stmt->bindParam(2, $ownerEmail);
        $stmt -> execute();
        return $stmt;
    }

}

?>