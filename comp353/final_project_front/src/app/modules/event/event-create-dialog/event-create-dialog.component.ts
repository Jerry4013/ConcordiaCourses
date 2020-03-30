import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { EventService } from 'src/app/services/event/event.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-event-create-dialog',
  templateUrl: './event-create-dialog.component.html',
  styleUrls: ['./event-create-dialog.component.scss']
})
export class EventCreateDialogComponent implements OnInit {

  form:FormGroup;

  constructor(
    private eventService: EventService,
    public dialogRef: MatDialogRef<EventCreateDialogComponent>) { }

  ngOnInit() {
    this.form = new FormGroup({
      'title': new FormControl('', Validators.required),
      'description': new FormControl('', Validators.required),
      'eventManager': new FormControl('', [Validators.required, Validators.email])
    });
  }

  cancel(): void {
    this.dialogRef.close();
  }

  submit():void{
    if(this.form.invalid) return;
    this.eventService.createEvent(this.form.value).subscribe(
      res=>{
        this.dialogRef.close(res);
      },
      err=>{
        this.form.get('eventManager').setErrors({message: 'Invalid Email'});
      }
    );
  }
}
