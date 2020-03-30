import { Component, OnInit, Input } from '@angular/core';
import { MessageData } from '../../models/MessageData';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-chat-bubble',
  templateUrl: './chat-bubble.component.html',
  styleUrls: ['./chat-bubble.component.scss']
})
export class ChatBubbleComponent implements OnInit {

  @Input() message: MessageData;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  isSelf():boolean{
    return this.message.sender == AuthService.user.email;
  }

}
