<?php
class EventManager {	
    
    public $id;
    public $email;
	public $accountNo;
	public $bankName;
	public $bankAddress;

    public function __construct($id, $email, $accountNo, $bankName, $bankAddress){
        $this->id = $id;
        $this->email = $email;
        $this->accountNo = $accountNo;
        $this->bankName = $bankName;
		$this->bankAddress = $bankAddress;

    }
}
?>