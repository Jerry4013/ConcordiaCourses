import { Injectable } from '@angular/core';
import { HttpRestAPIService } from '../http-rest-api.service';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { environment } from '../../../environments/environment'; 



@Injectable({
  providedIn: 'root'
})
export class CommentRepoService {

  urls: object;

  constructor(private http: HttpClient) { 

    let domain = environment.path.commentAPI;
    let url = {
      'addComment': domain + "addComment.php"
    };
    this.urls = url;
  }


  addCommentToPost(userEmail: string, comment:string, postId: string): Observable<any>{

    let data = new FormData();
    data.set('content', comment);
    data.set('postID', postId);
    data.set('authorID', userEmail);
    return this.http.post(this.urls['addComment'], data);
    
  }
}
