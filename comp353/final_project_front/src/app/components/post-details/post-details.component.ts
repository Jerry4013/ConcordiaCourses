import { Component, OnInit } from '@angular/core';
import { Post } from '../../data-models/post'; 
import { User } from '../../data-models/user';
import { Comment } from '../../data-models/comment'; 

import { ActivatedRoute } from '@angular/router';
import { PostRepoService } from '../../services/post-repo/post-repo.service';
import { CommentRepoService } from '../../services/comment-repo/comment-repo.service';



@Component({
  selector: 'app-post-details',
  templateUrl: './post-details.component.html',
  styleUrls: ['./post-details.component.scss']
})
export class PostDetailsComponent implements OnInit {

  //should inject these properties
  userWhoPosted : User;

  userSession: string;
  postId: string; 
  currentPost : Post;
  comments: Comment[];

  public sendCommentField: string;
  
  constructor(private route: ActivatedRoute, private postRepo: PostRepoService,
  private commentRepo : CommentRepoService ) { 
  }

  ngOnInit() {
    
    this.postId = this.route.snapshot.paramMap.get('postId');
    this.userSession = "dbunker3@wunderground.com"; 
    this.loadPostDetails();
  }


  loadPostDetails(){
    this.postRepo.getPostDetails(this.postId).subscribe(
       (data: any) => {
          this.parseResponse(data);
        });
  }

  parseResponse(data: any){

    
    let postDetails = data.postDetails;
    let authorDetails = data.postAuthorDetails;
    let commentArray = data.comments;

    //create post obj
    this.currentPost = new Post(postDetails.id, postDetails.url, postDetails.content, 
      postDetails.date, postDetails.isCommentable, postDetails.isPublic, postDetails.groupId, 
      postDetails.authorEmail);

    //create author obj

    let authorName = authorDetails.name.split(" ");
    this.userWhoPosted = new User(authorName[0], authorName[1], '',authorDetails.email);

    let post_comments = [];
    commentArray.forEach(function(comment){

      if(comment != null){
      post_comments.push(new Comment(comment.id, comment.content, comment.date, 
        comment.authorEmail, comment.postId));
      }
    });

    this.comments = post_comments;
  
  }

  sendComment(){

    
    //create comment obj
    let userEmail = this.userSession;//curUser
    let forPost = this.postId;//curPost
    let date = new Date();
    let dateStr = date.toISOString().split('T')[0];
    let newComment = new Comment("0", this.sendCommentField, dateStr, userEmail, forPost);
    this.comments.push(newComment);
    
    //send to service
    this.commentRepo.addCommentToPost(newComment.authorEmail, newComment.content, newComment.postId)
    .subscribe(
      (data: any) => {
        
        alert(data.msg);
      }
    );

    this.sendCommentField = ""
  }
}
