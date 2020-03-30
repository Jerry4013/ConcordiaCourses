import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subject} from "rxjs";
import {environment} from "../../../environments/environment";
import {EventModel} from "../../modules/event/EventModel";
import {GroupModel} from "../../modules/event/GroupModel";
import { HttpRestAPIService } from '../http-rest-api.service';
import { AuthService } from '../auth/auth.service';
import { ParticipantModel } from 'src/app/data-models/ParticipantModel';

@Injectable({
  providedIn: 'root'
})
export class EventService extends HttpRestAPIService {

  @Output() eventSelected: EventEmitter<EventModel> = new EventEmitter();

  constructor(http: HttpClient, authService: AuthService) {
    super(http, authService);
  }

  public getAllManagedEvents(email: string): Observable<EventModel[]>{
    return this.GET(
      environment.path.eventAPIBase + "getAllManagedEvents.php?email=" + email
    );
  }

  public getAllEventsByUser(email: string): Observable<EventModel[]>{
    return this.GET(
      environment.path.eventAPIBase + "getAllEventsForUser.php?email=" + email
    );
  }

  public createEvent(formData: FormData) {
    return this.POST(
      environment.path.eventAPIBase + "createEvent.php",
      formData
    );
  }

  public editEvent(formData: any) {
    return this.POST(
      environment.path.eventAPIBase + "editEvent.php",
      formData
    );
  }

  public deleteEvent(eventID: number) {
    return this.DELETE(
      environment.path.eventAPIBase + "deleteEvent.php?id="+eventID
    );
  }

  public getAllGroupsForEvent(eventID: number): Observable<GroupModel[]>{
    return this.GET(
      environment.path.groupAPIBase + "getAllGroupsForEvent.php?eventID=" + eventID
    );
  }

  public joinGroup(formData: FormData): Observable<any> {
    return this.POST(
      environment.path.groupAPIBase + "joinRequest.php",
      formData
    );
  }

  getAllParticipants(eventID: number): Observable<ParticipantModel[]> {
    return this.GET(
      environment.path.eventAPIBase + "getAllEventParticipants.php?eventID="+eventID
    );
  }

  removeParticipant(eventID: number, email: string) {
    return this.DELETE(
      environment.path.eventAPIBase + `removeUserFromEvent.php?eventID=${eventID}&user=${email}`
    );
  }

  addParticipant(eventID: number, user: string) {
    return this.POST(
      environment.path.eventAPIBase + `addExistingUserToEvent.php?user=${user}&eventID=${eventID}`,
      null
    );
  }
}
