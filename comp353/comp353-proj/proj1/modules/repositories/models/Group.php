<?php
class Group {	
    public $groupId = '';
    public $eventId = '';
	public $ownerEmail = '';
	public $title = '';

    public $post;

    public function __construct($gID, $eID, $ownID, $header){
        $this->groupId = $gID;
        $this->eventId = $eID;
        $this->ownerEmail = $ownID;
        $this->title = $header;
    }
}
?>