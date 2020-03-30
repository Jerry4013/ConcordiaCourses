import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../../environments/environment'; 




@Injectable({
  providedIn: 'root'
})
export class PostRepoService {

  private urls: object; 

  constructor(private http: HttpClient) { 
    let domain = environment.path.postAPI;
    debugger;
    this.urls = {
      'allPost': domain + "getPostForGroup.php?groupId=",
      'postDetails': domain + "getPostDetailsAndComments.php?postID="
    }
  }

  getPostForGroups(groupId: string): Observable<any>{
    return this.http.get(this.urls['allPost'] + groupId);
  }

  getPostDetails(postId: string): Observable<any>{
    return this.http.get(this.urls['postDetails'] + postId);
  }

}
