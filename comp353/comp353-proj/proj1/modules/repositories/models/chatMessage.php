<?php
class ChatMessage {	
    public $chatID;
    public $sender = '';
    public $receipient = '';
	public $content = '';
	public $sentTime = '';

    public function __construct($chatID, $sender, $receipient, $content, $sentTime){
        $this->chatID = $chatID;
        $this->sender = $sender;
        $this->receipient = $receipient;
        $this->content = $content;
        $this->sentTime = $sentTime;
    }
}
?>