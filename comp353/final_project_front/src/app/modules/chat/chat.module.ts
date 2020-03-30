import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ChatWindowComponent, CreateChatDialog } from './components/chat-window/chat-window.component';
import { ChatCapsuleComponent } from './components/chat-capsule/chat-capsule.component';
import { ChatBottomWindowComponent } from './components/chat-bottom-window/chat-bottom-window.component';
import { MatBottomSheetModule } from '@angular/material';
import { SharedModule } from '../shared/shared.module';
import { ChatBubbleComponent } from './components/chat-bubble/chat-bubble.component';



@NgModule({
  declarations: [
    CreateChatDialog, 
    ChatWindowComponent, 
    ChatCapsuleComponent, 
    ChatBottomWindowComponent, 
    ChatBubbleComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    MatBottomSheetModule
  ],
  entryComponents:[
    ChatBottomWindowComponent,
    CreateChatDialog
  ],
  exports:[
    ChatWindowComponent
  ]
})
export class ChatModule { }
