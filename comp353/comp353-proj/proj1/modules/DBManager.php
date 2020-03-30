<?php

class DBManager {

	private $pdo = null;

	function __construct(){
//    $user = "erc353_2";
//    $pass = "yDeaq9";
//    $dbname = "erc353_2";
//	$url = "mysql:host=erc353.encs.concordia.ca;dbname=" . $dbname;

        $user = "root";
        $pass = "root";
        $dbname = "comp353";
        $url = "mysql:host=localhost;dbname=" . $dbname;

//        if(getenv("runtime") == "docker"){
//            $pass = "root";
//            $user = "root";
//            $url = "mysql:host=db;dbname=dbproject";
//        }

        $this->pdo = new PDO($url, $user, $pass);
	}

/*
    public function __construct($url, $dbname, $user, $pass) {
				//$url = "mysql:host=localhost;dbname=$dbname";
		$this->pdo = new PDO($url . $dbname, $user, $pass);
	}
*/
    public function getHandle(){
        return $this->pdo;
    }

	public function runQuery($q){

		$pdo = $this->pdo;
		//$stm = $pdo->query("SELECT VERSION()");
        $stm = $pdo->query($q);
		$data = $stm->fetch();
		return $data;
	}

	public function execute($q){
		$pdo = $this->pdo;
        $stm = $pdo->query($q);
		$data = $stm->fetchAll(PDO::FETCH_ASSOC);
		return $data;
	}

	public function getLastInsertedId(){
		return $this->pdo->lastInsertId();
	}


    /*
	public function getPerson(){
		$pdo = $this->pdo;

		$stmt = $pdo->query('SELECT * FROM Person LIMIT 1');
		$stmt->setFetchMode(PDO::FETCH_CLASS, 'Person');
		$user = $stmt->fetch();
		return $user;
	}

	public function addPerson($userId, $password, $firstname, $lastname, $middlename){

		$pdo = $this->pdo;

		$stmt = $pdo->prepare("CALL addPerson(?, ?, ?, ?, ?)");
		$stmt->bindParam(1, $userId);
		$stmt->bindParam(2, $password);
		$stmt->bindParam(3, $firstname);
		$stmt->bindParam(4, $lastname);
		$stmt->bindParam(5, $middlename);
		$stmt -> execute();

		return "";
	}
    */

}
?>