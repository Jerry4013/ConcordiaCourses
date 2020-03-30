import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {EmailService} from "../../../services/email/email.service";

@Component({
  selector: 'app-email-folders',
  templateUrl: './email-folders.component.html',
  styleUrls: ['./email-folders.component.scss']
})
export class EmailFoldersComponent implements OnInit {

  constructor(private emailService: EmailService) { }

  ngOnInit() {
  }

  inboxClicked() {
    this.emailService.inboxClick.emit();
  }

  sentClicked() {
    this.emailService.sentClick.emit();
  }

  newClicked() {
    this.emailService.newClick.emit();
  }
}
