import {Component, Input, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {EventService} from "../../../services/event/event.service";
import {AuthService} from "../../../services/auth/auth.service";
import {EventModel} from "../EventModel";
import {UserProfile} from "../../../data-models/user-profile";
import {GroupModel} from "../GroupModel";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Router } from '@angular/router';

@Component({
  selector: 'app-event-detail',
  templateUrl: './event-detail.component.html',
  styleUrls: ['./event-detail.component.scss']
})
export class EventDetailComponent implements OnInit, OnDestroy {
  eventSelectedSub = new Subscription();
  event: EventModel;
  user: UserProfile;
  groups: GroupModel[];
  myGroups: GroupModel[];

  constructor(
    private eventService: EventService,
    private _snackBar: MatSnackBar,
    private router: Router) { 

      this.event = this.router.getCurrentNavigation().extras.state ? this.router.getCurrentNavigation().extras.state.eventData : null;

      if(!this.event) this.goToList();
    }

  ngOnInit() {
    this.user = AuthService.user;
    
    this.eventSelectedSub = this.eventService.eventSelected.subscribe(event => {
      this.event = event;
      this.eventService.getAllGroupsForEvent(this.event.id).subscribe(res => {
        this.groups = res;
      })
    });
  }

  ngOnDestroy(): void {
    this.eventSelectedSub.unsubscribe();
  }

  joinGroup(index: number) {
    const formData = new FormData();
    formData.set('email', this.user.email);
    formData.set('groupId', this.groups[index].groupId.toString());
    this.eventService.joinGroup(formData).subscribe(res => {
      this._snackBar.open("Request Sent!", "", {
        duration: 2000
      })
    });
  }

  goToList():void{
    this.router.navigate(['event/list']);
  }

  createGroup():void{

  }

  leaveEvent():void{
    this.eventService.removeParticipant(this.event.id, AuthService.user.email).subscribe(
      res =>{
        this.goToList();
      }
    )
  }
}
