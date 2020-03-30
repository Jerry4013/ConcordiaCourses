<?php

include 'models/Event.php';
include 'models/EventManager.php';

class EventRepo {
	
	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}
	
	public function getAllEventsForUser($email){
		
		$q = "SELECT * FROM t_event
                left join event_details on t_event.id = event_details.eventID
				inner join t_participates On t_participates.eventID = t_event.id
                where participant = '$email'";
                
        return $this->formatEventsData($this->db->execute($q));   
	}

    public function getAllManagedEvents($email){

        $isAdmin = $this->db->execute("select count(*) from t_user where role = 'Admin' and email = '$email'")[0]['count(*)'] > 0;

        if($isAdmin){
            return $this->db->execute(
                "SELECT * FROM t_event left join event_details on t_event.id = event_details.eventID"
            );
        }else{
            return $this->db->execute(
                "SELECT * FROM t_event left join event_details on t_event.id = event_details.eventID where event_manager = '$email'"
            );
        }
    }
	
	public function editEvent($data){
        $id = $data["id"];
        $status = $data["status"];
        $eventManager = $data["eventManager"];
        $title = $data["title"];
        $description = $data["description"];
        
        $dID = $data["dID"];
        $startDate = $data["startDate"];
        $endDate = $data["endDate"];
        $organizationType = $data["organizationType"];
        $storageUsed = $data["storageUsed"];
        $bandwidthUsed = $data["bandwidthUsed"];
        $event_address = $data["eventAddress"];
        $account_no = $data["bankAccount"];
        $bank_name = $data["bankName"];

        $this->db->execute(
            "UPDATE t_event set status = '$status', title = '$title', description = '$description' where id = '$id'"
        );

        $hasDetails = $this->db->execute("select count(*) from event_details where dID = '$id'")[0]['count(*)'] > 0;

        if($hasDetails){
            $q = "UPDATE event_details set `start_date` = ?, end_date = ?, `organization_type` = ?, event_address = ?, account_no = ?, bank_name = ?, storage_used = ?, bandwidth_used = ? where dID = '$id'";

            $stmt = $this->db->getHandle()->prepare($q);

            $stmt->bindValue(1, $startDate? $startDate : null);
            $stmt->bindValue(2, $endDate? $endDate : null);
            $stmt->bindValue(3, $organizationType);
            $stmt->bindValue(4, $event_address);
            $stmt->bindValue(5, $account_no);
            $stmt->bindValue(6, $bank_name);
            $stmt->bindValue(7, $storageUsed);
            $stmt->bindValue(8, $bandwidthUsed);

            $stmt -> execute();
        }else{
            $q = "INSERT into event_details(`start_date`, end_date, organization_type, event_address, account_no, bank_name, storage_used, bandwidth_used, eventID)
            values(?,?,?,?,?,?,?,?,?)";

            $stmt = $this->db->getHandle()->prepare($q);

            $stmt->bindValue(1, $startDate? $startDate : null);
            $stmt->bindValue(2, $endDate? $endDate : null);
            $stmt->bindValue(3, $organizationType);
            $stmt->bindValue(4, $event_address);
            $stmt->bindValue(5, $account_no);
            $stmt->bindValue(6, $bank_name);
            $stmt->bindValue(7, $storageUsed);
            $stmt->bindValue(8, $bandwidthUsed);
            $stmt->bindValue(9, $id);

            $stmt -> execute();
        }
	}
	
	public function addExistingUserToEvent($email, $eventID){

        $alreadyJoined = $this->db->execute("select count(*) from t_participates where participant = '$email' and eventID = '$eventID'")[0]['count(*)'] > 0;

        if($alreadyJoined) return false;

		$q = "INSERT INTO t_participates(participant, eventID) VALUES (?,?);"; 

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, $email);
        $stmt -> bindValue(2, $eventID);
        $stmt -> execute();

        return $this->db->execute("SELECT name, phone, email FROM t_user WHERE email = '$email'")[0];
	}
	
	public function removeUserFromEvent($email, $eventID){

        $q = "DELETE FROM t_participates WHERE participant = ? AND eventID = ?;";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $email);
		$stmt->bindParam(2, $eventID);
        return $stmt -> execute();
    }
    
    public function getAllParticipants($eventID){
        return $this->db->execute("SELECT email, phone, name FROM t_participates 
        JOIN t_user on t_user.email = t_participates.participant
        JOIN t_event on t_event.id = eventID
        where t_event.id = '$eventID'");
    }
	
	public function createEvent($data){
        $eventManager = $data["eventManager"];
        $title = $data["title"];
        $description = $data["description"];

        $this->db->execute(
            "INSERT INTO t_event(title, event_manager, description) VALUES ('$title', '$eventManager', '$description');");

        return $this->db->getLastInsertedId();
	}

    public function deleteEvent($id)
    {
        $this->db->execute("DELETE FROM t_event WHERE id = $id;");
    }

    private function formatEventsData($eventsData){

        for($i = 0; $i < count($eventsData); $i++){
            $arrEntry = $eventsData[$i];
            
            unset($eventsData[$i]['bandwidth_used']);
            unset($eventsData[$i]['storage_used']);
        }

        return $eventsData;
    }
}