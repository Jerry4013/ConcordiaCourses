import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {EmailModel} from "../../modules/email/models/EmailModel";

@Injectable({
  providedIn: 'root'
})
export class EmailService  {

  @Output() inboxClick: EventEmitter<any> = new EventEmitter();
  @Output() sentClick: EventEmitter<any> = new EventEmitter();
  @Output() newClick: EventEmitter<any> = new EventEmitter();
  @Output() emailSelected: EventEmitter<EmailModel> = new EventEmitter();

  constructor(private http: HttpClient) { }

  public getAllEmailsByRecipient(recipient: string): Observable<EmailModel[]>{
    return this.http.get<EmailModel[]>(
      environment.path.emailAPIBase + "getEmailByRecipient.php?recipient=" + recipient
    );
  }

  public getAllEmailsBySender(sender: string): Observable<EmailModel[]>{
    return this.http.get<EmailModel[]>(
      environment.path.emailAPIBase + "getEmailBySender.php?sender=" + sender
    );
  }

  public createEmail(formData: FormData): Observable<any>{
    return this.http.post(
      environment.path.emailAPIBase + "createEmail.php",
      formData
    );
  }
}
