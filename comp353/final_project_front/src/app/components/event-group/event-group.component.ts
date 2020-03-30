import { Component, OnInit, Input } from '@angular/core';
import { Group } from '../../data-models/group'; 
import { GroupRepoService } from '../../services/group-repo/group-repo.service';
import { AuthService } from 'src/app/services/auth/auth.service';
import {EventModel} from "../../modules/event/EventModel";
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-event-group',
  templateUrl: './event-group.component.html',
  styleUrls: ['./event-group.component.scss']
})
export class EventGroupComponent implements OnInit {

  currentEventID: string;
  sessionUser: string;

  groups: Group[];
  participatingGroups: Group[];
  pendingGroups: Group[];

  constructor(private route: ActivatedRoute, public groupRepo: GroupRepoService) { 
    this.sessionUser = AuthService.user.email;//"cgarvaghn@google.com";// 
    this.groups = [];
    this.participatingGroups = []; 
    this.pendingGroups = [];
  }

  ngOnInit() { 
    this.currentEventID = this.route.snapshot.paramMap.get('eventId');
    this.getAllGroupUserParticipates();
    this.getAllGroupsInPending();
    this.getAllGroupsForEvent();
  }

  getAllGroupsForEvent(){
    this.groupRepo.getAllGroupsForEvent(this.currentEventID).subscribe(
      (data: any) => {
        this.groups = this.parseResponseToList(data);
      });
  }

  getAllGroupUserParticipates(){
      this.groupRepo.getGroupsUserParticipatesIn(this.sessionUser).subscribe(
      (data: any) => {
        this.participatingGroups = this.parseResponseToList(data);
      });
  }

  getAllGroupsInPending(){
    this.groupRepo.getGroupUserIsPending(this.sessionUser).subscribe(
      (data: any) => {
        this.pendingGroups = this.parseResponseToList(data);
      });
  }


  parseResponseToList(data: any): Group[]{
    var serverGroup = [];
    data.forEach(function(group){
      serverGroup.push(new Group(group.groupId, group.eventId, group.ownerEmail, group.title));
    });
    return serverGroup;
  }


  joinGroup(group: Group): void{
    
    this.pendingGroups.push(group);
    this.groupRepo.sendGroupRequest(this.sessionUser, group.groupId).subscribe(
     (response: any) => {
       
        alert(response.msg);
      }); 
  }

  leaveGroup(group: Group): void{
    
    let index = this.findIndex(group, this.participatingGroups);
    this.groupRepo.leaveGroup(this.sessionUser, group.groupId).subscribe(
     (response: any) => {
       
        alert(response.msg);
      }); 
    this.participatingGroups.splice(index, 1); 
  }
  


  isMember(group: Group): boolean{
    return this.findIndex(group, this.participatingGroups) != -1;  
  }

  hasRequested(group: Group): boolean{
    return this.findIndex(group, this.pendingGroups) != -1;  
  }

  findIndex(group: Group, list: Group[]): number{
    for (var i = 0; i < list.length; i++) {
      if(list[i].groupId == group.groupId)
        return i;
    }
    return -1;
  }

}
