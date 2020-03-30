import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Group } from '../../data-models/group'; 
import { environment } from '../../../environments/environment'; 


@Injectable({
  providedIn: 'root'
})
export class GroupRepoService {

  private urls: object;

  constructor(private http: HttpClient) { 

    let domain = environment.path.groupAPIBase;

    var urls = {
      'users-group' : domain + "participates.php?email=", 
      'event-groups' : domain + "getAllGroupsForEvent.php?eventID=", 
      'group-pending' : domain + "getGroupsUserRequestedToJoin.php?email=", 
      'send-request' : domain + "joinRequest.php",
      'leave-group' : domain + "leavegroup.php"
    }
    this.urls = urls;
  }

  getAllGroupsForEvent(eventId: string): Observable<any>{
    let url = this.urls['event-groups'] + eventId; 
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json; charset=utf-8');
    return this.http.get(url);
  }

  //groups users has sent join request for
  getGroupUserIsPending(userEmail: string): Observable<any> {
    let url = this.urls['group-pending'] + userEmail; 
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json; charset=utf-8');
    return this.http.get(url); 
  }

  getGroupsUserParticipatesIn(userEmail: string): Observable<any> {
    let url = this.urls['users-group'] + userEmail; 
    const headers = new HttpHeaders();
    headers.set('Content-Type', 'application/json; charset=utf-8');
    return this.http.get(url);
  }

  leaveGroup(userEmail: string, groupId: string): Observable<any>{
    let data = new FormData(); 
    data.set('email', userEmail);
    data.set('groupId', groupId);
    return this.sendPost(this.urls['leave-group'], data);
  }


  sendGroupRequest(userEmail: string, groupId: string): Observable<any>{
    let data = new FormData(); 
    data.set('email', userEmail);
    data.set('groupId', groupId);
    return this.sendPost(this.urls['send-request'], data);
  }

  sendPost(url: string, data: FormData): Observable<any>{
     return this.http.post(url, data);
  }


}
