import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth/auth.service';
import { EventModel } from '../EventModel';
import { ParticipantModel } from 'src/app/data-models/ParticipantModel';
import { EventService } from 'src/app/services/event/event.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  @Input() eventData: EventModel;
  @Output('onFormSubmit') onFormSubmit = new EventEmitter();

  eventForm: FormGroup;
  participantControl: FormControl;
  participants: ParticipantModel[];

  onSubmit() {
    const data = this.eventForm.getRawValue() as EventModel;
    data.dID = this.eventData.dID;

    if(this.eventForm.valid){
      this.onFormSubmit.emit({action:"edit", data});
    }
  }

  deleteEvent(): void{
    this.onFormSubmit.emit({action:"delete", data:this.eventForm.getRawValue()});
  }

  resetEvent(): void{
    this.eventForm = new FormGroup({
      "id" : new FormControl(this.eventData? this.eventData.id : -1, Validators.required),
      "title" : new FormControl(this.eventData? this.eventData.title : "",Validators.required),
      "status" : new FormControl(this.eventData? this.eventData.status : ""),
      "description" : new FormControl(this.eventData? this.eventData.description : "",Validators.required),
      "eventManager" : new FormControl(this.eventData? this.eventData.event_manager : "",Validators.required),
      "startDate" : new FormControl(this.eventData.start_date? this.eventData.start_date : ""),
      "endDate" : new FormControl(this.eventData.end_date? this.eventData.end_date : null),
      "organizationType" : new FormControl(this.eventData.organization_type? this.eventData.organization_type : ""),
      "storageUsed" : new FormControl(this.eventData.storage_used? this.eventData.storage_used : ""),
      "bandwidthUsed" : new FormControl(this.eventData.bandwidth_used? this.eventData.bandwidth_used : ""),
      "eventAddress" : new FormControl(this.eventData.event_address? this.eventData.event_address : ""),
      "bankName" : new FormControl(this.eventData.bank_name? this.eventData.bank_name : ""),
      "bankAccount" : new FormControl(this.eventData.account_no? this.eventData.account_no : ""),
    });

    this.eventForm.get('id').disable();
    this.eventForm.get('status').disable();
    
    if(!this.authService.isAdmin){
      this.eventForm.get('eventMamanger').disable();
      this.eventForm.get('bandwidthUsed').disable();
      this.eventForm.get('storageUsed').disable();
    }
  }

  constructor(private authService: AuthService, private eventService: EventService, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.resetEvent();
    this.participantControl = new FormControl("", Validators.email);

    this.eventService.getAllParticipants(this.eventData.id).subscribe(
      res=>{
        this.participants = res;
      }
    );
  }

  addParticipant():void{
    if(this.participantControl.invalid || this.participantControl.value == '') return;

    this.eventService.addParticipant(this.eventData.id, this.participantControl.value).subscribe(
      res => {
        this.participants.push(res);
        this.participantControl.setValue("");
        this.snackBar.open("User Added To Event", "OK", {duration: 4000});
      },
      err=>{
        this.snackBar.open("Invalid Email", "OK", {duration: 4000});
        this.participantControl.setErrors({});
      }
    )
  }

  removeParticipant(email: string):void{
    this.eventService.removeParticipant(this.eventData.id, email).subscribe(
      res => {
        this.participants = this.participants.filter(
          participant => participant.email != email
        );
        this.snackBar.open("Participant Removed", "OK", {duration: 4000});
      },
      err=>{
        this.snackBar.open("Something went wrong...", "OK", {duration: 4000});
      }
    )
  }

  isSelf(email: string):boolean {
    return AuthService.user.email == email;
  }
}
