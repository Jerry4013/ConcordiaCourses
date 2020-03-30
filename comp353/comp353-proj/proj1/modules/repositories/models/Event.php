<?php
class Event {	
    
    public $id;
    public $status;
	public $eventManager;
	public $startDate;
	public $endDate;
	public $organizationType;
	public $storageUsed;
	public $bandwidthUsed;
	public $title;
	public $description;


    public function __construct($id, $status, $eventManager, $startDate, $endDate, $organizationType, $storageUsed, $bandwidthUsed, $title, $description){
        $this->id = $id;
        $this->status = $status;
        $this->eventManager = $eventManager;
        $this->startDate = $startDate;
		$this->endDate = $endDate;
		$this->organizationType = $organizationType;
        $this->storageUsed = $storageUsed;
		$this->bandwidthUsed = $bandwidthUsed;		
		$this->title = $title;
		$this->description = $description;	
    }
}
?>