import { Component, OnInit, ViewChild } from '@angular/core';
import { EventModel } from "../EventModel";
import { EventService } from "../../../services/event/event.service";
import { AuthService } from "../../../services/auth/auth.service";
import { Router } from '@angular/router';
import { MatSnackBar, MatDialog } from '@angular/material';
import { EventFormComponent } from '../event-form/event-form.component';
import { EventCreateDialogComponent } from '../event-create-dialog/event-create-dialog.component';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {
  managedEvents: EventModel[];
  myEvents: EventModel[];

  tabIndex: number;

  @ViewChild('createForm', { static: false}) form: EventFormComponent;

  constructor(
    private eventService: EventService, 
    private authService: AuthService, 
    private router: Router,
    private _snackBar: MatSnackBar,
    private dialog: MatDialog
  ) { }

  ngOnInit() {
    this.updateEvent();
  }

  createEvent():void{
    const dialogRef = this.dialog.open(EventCreateDialogComponent, {
      width: "450px",
      data: {res: ""}
    });

    dialogRef.afterClosed().subscribe(
      res=>{
        this.managedEvents.push(res);
        this._snackBar.open("Event has been created", "Ok", {duration: 4000});
        this.tabIndex = 1;
      }
    );
  }

  handleFormData($event: any): void {
    if ($event.action) {
      switch ($event.action) {
        case 'edit':
          this.eventService.editEvent($event.data).subscribe(
            res => {
              this.updateEvent();
              this._snackBar.open("Event has been Edited", "Ok", {duration: 4000});
            },
            err => {
              console.log(err);
              this._snackBar.open("Something went wrong...", "Ok", {duration: 4000});
            }
          );
          break;

        case 'delete': {
          this.eventService.deleteEvent($event.data.id).subscribe(
            res => {
              this.removeEvent($event.data.id);
              this._snackBar.open("Event has been Deleted", "Ok", {duration: 4000});
              console.log(res);
            },
            err=>{
              this._snackBar.open(err.error, "Ok", {duration: 4000});
              console.error(err);
            }
          )
        }
      }
    }
  }

  get isAdmin() {
    return this.authService.isAdmin;
  }

  goToDetails(event: EventModel) {
    this.router.navigate(['event/detail/' + event.id], {state:{eventData: event}});
  }

  private updateEvent(): void {
    this.eventService.getAllEventsByUser(AuthService.user.email).subscribe(
      res => this.myEvents = res
    );

    this.eventService.getAllManagedEvents(AuthService.user.email).subscribe(
      res => this. managedEvents= res
    );
  }

  private removeEvent(eventID: number):void{
    this.myEvents = this.myEvents.filter((event: EventModel) => event.id != eventID);
    this.managedEvents = this.managedEvents.filter((event: EventModel) => event.id != eventID);
  }

  isMissingInfo(event: EventModel): boolean {
    return Object.keys(event).filter(key => !event[key]).length > 0;
  }
}
