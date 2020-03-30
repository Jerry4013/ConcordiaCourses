<?php
class User {	
    
    public $email;
    public $password;
	public $role;
	public $birthDate;
	public $name;
	public $address;
	public $phone;
	public $organization;


    public function __construct($email, $password, $role, $birthDate, $name, $address, $phone, $organization){
        $this->email = $email;
        $this->password = $password;
        $this->role = $role;
        $this->birthDate = $birthDate;
		$this->name = $name;
		$this->address = $address;
        $this->phone = $phone;
		$this->organization = $organization;		
    }
}
?>