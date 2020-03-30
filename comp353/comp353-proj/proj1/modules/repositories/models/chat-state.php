<?php
class ChatState {	
    public $id = '';
    public $lastMessage = '';
	public $unreadCount = '';
	public $participantUsernames = '';

    public function __construct($id, $lastMessage, $unreadCount, $participantUsernames){
        $this->id = $id;
        $this->lastMessage = $lastMessage;
        $this->unreadCount = $unreadCount;
        $this->participantUsernames = $participantUsernames;
    }
}
?>