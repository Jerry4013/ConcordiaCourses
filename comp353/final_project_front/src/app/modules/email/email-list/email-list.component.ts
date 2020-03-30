import {Component, OnDestroy, OnInit} from '@angular/core';
import {EmailModel} from "../models/EmailModel";
import {EmailService} from "../../../services/email/email.service";
import {Subscription} from "rxjs";
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-email-list',
  templateUrl: './email-list.component.html',
  styleUrls: ['./email-list.component.scss']
})
export class EmailListComponent implements OnInit, OnDestroy {
  emails: EmailModel[];
  inboxClickSub = new Subscription();
  sentClickSub = new Subscription();

  constructor(private emailService: EmailService, private authService: AuthService) { }

  ngOnInit() {
    this.emailService.getAllEmailsByRecipient(AuthService.user.email).subscribe( res => {
      this.emails = res;
    });
    this.inboxClickSub = this.emailService.inboxClick.subscribe(() => {
      this.emailService.getAllEmailsByRecipient(AuthService.user.email).subscribe( res => {
        this.emails = res;
      });
    });
    this.sentClickSub = this.emailService.sentClick.subscribe(() => {
      this.emailService.getAllEmailsBySender(AuthService.user.email).subscribe( res => {
        this.emails = res;
      });
    });
  }

  ngOnDestroy(): void {
    this.inboxClickSub.unsubscribe();
    this.sentClickSub.unsubscribe();
  }


  onEmailSelected(email: EmailModel) {
    this.emailService.emailSelected.emit(email);
  }
}
