<?php

include 'models/User.php';

class UserRepo {
	
	private $db = null;
   
    public function __construct($dbManager) {
        $this->db = $dbManager; 
	}
	
	public function createUser($user){
		$q = "INSERT INTO t_user(email, password, role, birth_date, name, address, phone, organization)
              VALUES (?,?,?,?,?,?,?,?);"; 

        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindValue(1, $user->email);
        $stmt -> bindValue(2, $user->password);
        $stmt -> bindValue(3, $user->role);
        $stmt -> bindValue(4, $user->birthDate);
        $stmt -> bindValue(5, $user->name);
        $stmt -> bindValue(6, $user->address);
        $stmt -> bindValue(7, $user->phone);
        $stmt -> bindValue(8, $user->organization);
		$stmt -> execute();
        return $stmt;
	}
	
	public function validateUser($email, $password){
        $q = "SELECT * FROM t_user WHERE email = '$email' AND password = '$password';"; 
        
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'DBUser');
        
        $dbUser = $stmt->fetch();

		if(isset($dbUser['email']))
			$user = new User($dbUser['email'], $dbUser['password'], $dbUser['role'], $dbUser['birth_date'], $dbUser['name'], $dbUser['address'], $dbUser['phone'], $dbUser['organization']); 
		else
			$user = false;

		return $user;
	}
	
	public function editUser($user){
		
        $q = "UPDATE t_user SET password = ?, role = ?, birth_date = ?, 
			name = ?, address = ?, phone = ? , organization = ? WHERE email = ?"; 
        $pdo = $this->db->getHandle();
		
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $user->password);
		$stmt->bindParam(2, $user->role);
		$stmt->bindParam(3, $user->birthDate);
		$stmt->bindParam(4, $user->name);
		$stmt->bindParam(5, $user->address);
		$stmt->bindParam(6, $user->phone);
		$stmt->bindParam(7, $user->organization);
		$stmt->bindParam(8, $user->email);
		$stmt -> execute();
        return $stmt;

	}

	public function deleteUser($email){

        $q = "DELETE FROM t_user WHERE email = ?;";
        $pdo = $this->db->getHandle();
		$stmt = $pdo->prepare($q);
		$stmt->bindParam(1, $email);
        $stmt -> execute();
        return $stmt;	
	}
	
	public function getUser($email){
        $q = "SELECT * FROM t_user WHERE email LIKE '" . $email . "';"; 
        
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'DBUser');
        
        $dbUser = $stmt->fetch();
        $user = new User($dbUser['email'], null, $dbUser['role'], $dbUser['birth_date'], $dbUser['name'], $dbUser['address'], $dbUser['phone'], $dbUser['organization']); 

		return $user;
	}
	
	public function getAllUsersForEvent($eventID){
		
		$q = "SELECT * FROM t_user
				inner join t_participates On t_participates.email = t_user.email
				where eventID = " . $eventID;
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);     
        $dbUser = $stmt->fetchAll(PDO::FETCH_ASSOC);      
        $users = array();

        for($i = 0; $i < count($dbUser); $i++){
            $arrEntry = $dbUser[$i];
            
            array_push($users, new User(
				$arrEntry['email'],
				null, 
				$arrEntry['role'], 
				$arrEntry['birth_date'], 
				$arrEntry['name'],
				$arrEntry['address'], 
				$arrEntry['phone'], 
				$arrEntry['organization']));
        }
        return $users;
	}

    public function getAllUsers()
    {
        $q = "SELECT * FROM t_user;";
        $pdo = $this->db->getHandle();
        $stmt = $pdo->query($q);
        $dbUser = $stmt->fetchAll(PDO::FETCH_ASSOC);
        $users = array();

        for($i = 0; $i < count($dbUser); $i++){
            $arrEntry = $dbUser[$i];

            array_push($users, new User(
                $arrEntry['email'],
                null,
                $arrEntry['role'],
                $arrEntry['birth_date'],
                $arrEntry['name'],
                $arrEntry['address'],
                $arrEntry['phone'],
                $arrEntry['organization']));
        }
        return $users;
    }

}