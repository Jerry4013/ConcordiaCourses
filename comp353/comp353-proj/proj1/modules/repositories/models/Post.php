<?php
class Post {	
    
    public $id;
    public $url;
    public $content;
    public $date;
    public $isCommentable;
    public $isPublic;

    public $groupId;
    public $authorEmail;

    public function __construct($id,$url,$content,$date,$isCommentable,$isPublic,$groupId,$authorId){
        $this->id = $id; 
        $this->url = $url;
        $this->content = $content; 
        $this->date = $date; 
        $this->isCommentable = $isCommentable;
        $this->isPublic = $isPublic;
        $this->groupId = $groupId; 
        $this->authorEmail = $authorId;
    }

}
?>