<?php
class Comment {	
    
    public $id;
    public $postID;
	public $content;
	public $date;

    public $authorEmail;

    public function __construct($id, $postID, $content, $date, $authorEmail){
        $this->id = $id;
        $this->postID = $postID;
        $this->content = $content;
        $this->date = $date;
		$this->authorEmail = $authorEmail;
    }
}
?>