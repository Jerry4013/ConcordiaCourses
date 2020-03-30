import { Injectable } from '@angular/core';
import { Observable, timer, Subscription, Subject } from 'rxjs';
import { switchMap, retry, repeat, startWith, tap } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { MessageData } from 'src/app/modules/chat/models/MessageData';
import { HttpRestAPIService } from '../http-rest-api.service';

import { environment } from '../../../environments/environment'; 
import { ChatRequest } from 'src/app/data-models/chatRequest';
import { ChatState } from 'src/app/modules/chat/models/chat-state';
import { AuthService } from '../auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class ChatServiceService extends HttpRestAPIService {

  messagePolls = new Map<number, Subscription>();
  chatStates: ChatState[];

  public messagePublisher = new Subject<any>();

  constructor(http: HttpClient, authService: AuthService) {
    super(http,authService);

    this.authService.$isLoggedIn.subscribe(
      isAuthenticated => {
        if(!isAuthenticated){
          this.endPoll();
        }
      }
    )
  }

  public getAllChats(username:string): Observable<ChatState[]>{
    return this.GET(environment.path.chatAPIBase+"getAllChats.php?username='jim@gmail.com'").pipe(
      tap(
        (res:ChatState[])=>{
          res.forEach(
            (state:ChatState)=>{
              const sub = this.startPoll(state.cID).subscribe(
                messages=>{
                  this.messagePublisher.next({chatID:state.cID ,content:messages})
                }
              );
              
              this.messagePolls.set(state.cID, sub);
            }
          );
        }
      )
    );
  }

  public getAllMessages(chatID:number): Observable<MessageData[]>{
    return this.GET(environment.path.chatAPIBase+"getAllMessages.php?chatID=%22"+chatID+"%22");
  }

  public sendMessage(message: MessageData, chatID: number): Observable<any>{
    return this.POST(environment.path.chatAPIBase+"postMessage.php?chatID="+chatID, message);
  }

  public createChat(request: ChatRequest):Observable<any>{
    return this.POST(environment.path.chatAPIBase+"createChat.php", request);
  }

  public startPoll(chatID:number):Observable<any>{
    return timer(2000).pipe(
      startWith(2000),
      switchMap(tick => this.getAllMessages(chatID)),
      retry(2),
      repeat()
    );
  }

  public endPoll():void{
    this.messagePolls.forEach((val:Subscription, key)=>{
      val.unsubscribe();
    });
  }
}
