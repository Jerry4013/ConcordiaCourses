import {Component, OnDestroy, OnInit} from '@angular/core';
import {EmailService} from "../../../services/email/email.service";
import {EmailModel} from "../models/EmailModel";
import {Subscription} from "rxjs";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-email-detail',
  templateUrl: './email-detail.component.html',
  styleUrls: ['./email-detail.component.scss']
})
export class EmailDetailComponent implements OnInit, OnDestroy {
  email: EmailModel;
  newEmailMode = true;
  newClickSub = new Subscription();
  emailSelectedSub = new Subscription();
  currentLoginUser: string = 'jim';
  constructor(private emailService: EmailService) { }

  ngOnInit() {
    this.newClickSub = this.emailService.newClick.subscribe(() => {
      this.newEmailMode = true;
    });
    this.emailSelectedSub = this.emailService.emailSelected.subscribe(email => {
      this.email = email;
      this.newEmailMode = false;
    })
  }

  ngOnDestroy(): void {
    this.newClickSub.unsubscribe();
    this.emailSelectedSub.unsubscribe();
  }

  onSubmit(f: NgForm) {
    const value = f.value;
    const formData = new FormData();
    formData.set('title', value.title);
    formData.set('sender', this.currentLoginUser);
    formData.set('recipient', value.recipient);
    formData.set('content', value.content);
    this.emailService.createEmail(formData).subscribe(res => {
      f.reset();
    });
  }
}
