import { Component, OnInit, Input } from '@angular/core';
import { ChatState } from '../../models/chat-state';
import { MatBottomSheet } from '@angular/material';
import { ChatBottomWindowComponent } from '../chat-bottom-window/chat-bottom-window.component';
import { AuthService } from 'src/app/services/auth/auth.service';
import { ChatServiceService } from 'src/app/services/chat/chat-service.service';

@Component({
  selector: 'app-chat-capsule',
  templateUrl: './chat-capsule.component.html',
  styleUrls: ['./chat-capsule.component.scss']
})
export class ChatCapsuleComponent implements OnInit {

  @Input() state:ChatState;

  constructor(private bottomSheet: MatBottomSheet, private authservice: AuthService, private chatService: ChatServiceService) { }

  ngOnInit() {
    this.chatService.messagePublisher.subscribe(
      data=>{
        if(data.chatID == this.state.cID){
          this.state.content = data.content[data.content.length-1].content;
        }
      }
    )
  }

  openChat():void{
    this.bottomSheet.open(ChatBottomWindowComponent,{data: this.state});
  }

  getOther():string{
    if(AuthService.user.email == this.state.sender){
      return this.state.receipient;
    }

    return this.state.sender;
  }
}
