<?php
class Email {
    
    public $id;
    public $title;
	public $sender;
	public $recipient;
	public $content;


    public function __construct($id, $title, $sender, $recipient, $content)
    {
        $this->id = $id;
        $this->title = $title;
        $this->sender = $sender;
        $this->recipient = $recipient;
        $this->content = $content;
    }

}
