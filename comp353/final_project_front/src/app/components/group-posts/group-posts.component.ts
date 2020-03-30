import { Component, OnInit } from '@angular/core';
import { Post } from '../../data-models/post'; 
import { ActivatedRoute } from '@angular/router';
import { PostRepoService } from '../../services/post-repo/post-repo.service';



@Component({
  selector: 'app-group-posts',
  templateUrl: './group-posts.component.html',
  styleUrls: ['./group-posts.component.scss']
})
export class GroupPostsComponent implements OnInit {

  private groupId: string;
  private posts: Post[];

  constructor(private route: ActivatedRoute, private postRepo: PostRepoService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('groupId');
    this.posts = []; 
    this.groupId = id;
    this.loadPostForGroup();
  }

  loadPostForGroup(){
    this.postRepo.getPostForGroups(this.groupId).subscribe(
      (data: any) => {
        this.posts = this.parseResponseToList(data);
      });
  }

  parseResponseToList(data): Post[]{
    
    var serverPosts = [];
    data.forEach(function(post){
      serverPosts.push(new Post(post.id, post.url, post.content, 
        post.date, post.isCommentable, post.isPublic, post.groupId, post.authorEmail));
    });
    return serverPosts;
  }
}

