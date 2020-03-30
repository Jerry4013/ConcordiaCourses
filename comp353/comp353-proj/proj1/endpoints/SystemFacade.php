<?php
class SystemFacade {	
    
    private $groupRepo;
    private $postRepo;

    public function __construct(){
        $manager = new DBManager();
        $this->groupRepo = new GroupRepo($manager);
        $this->postRepo = new PostRepo($manager);
    }

    

}
?>