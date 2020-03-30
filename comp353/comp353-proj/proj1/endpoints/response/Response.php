


<?php
class Response {	
    
    public $success = ''; //boolean
    public $msg = '';


    public function __construct($s, $mes){
        $this->success = $s;
        $this->msg = $mes;
    }
}
?>