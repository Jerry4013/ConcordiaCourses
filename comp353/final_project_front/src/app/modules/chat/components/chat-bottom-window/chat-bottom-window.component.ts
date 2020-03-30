import { Component, OnInit, Inject, ViewChild, ElementRef, AfterViewInit, ChangeDetectionStrategy, ChangeDetectorRef, OnDestroy, AfterViewChecked } from '@angular/core';
import { MatBottomSheetRef, MAT_BOTTOM_SHEET_DATA } from '@angular/material';
import { ChatServiceService } from 'src/app/services/chat/chat-service.service';
import { MessageData } from '../../models/MessageData';
import { ChatState } from '../../models/chat-state';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-chat-bottom-window',
  templateUrl: './chat-bottom-window.component.html',
  styleUrls: ['./chat-bottom-window.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ChatBottomWindowComponent implements OnInit {
  messages:MessageData[]; 

  @ViewChild("inputArea", {static:false}) input:ElementRef;
  @ViewChild("scroll", {static:false}) scroll:ElementRef;

  scrolled = false;
  isReady = false;

  constructor(
    private bottomSheemRef: MatBottomSheetRef,
    private chatService: ChatServiceService,
    private authService: AuthService,
    private ref: ChangeDetectorRef,
    @Inject(MAT_BOTTOM_SHEET_DATA) public data: ChatState
    ) { }

  ngOnInit() {
    this.chatService.messagePublisher.subscribe(
      data=>{
        if(data.chatID == this.data.cID){
          this.messages=data.content;
          this.ref.markForCheck();

          setTimeout(() => {
            if(!this.scrolled){
              this.scrollBottom();
              this.scrolled=true;
              this.isReady = true;
            }
          }, 0);
        }
      }
    );

    setTimeout(() => {
      this.input.nativeElement.focus();
    }, 500);
  }

  close():void{
    this.bottomSheemRef.dismiss();
  }

  sendMessage():void{
    this.input.nativeElement.focus();

    if(this.input.nativeElement.value =="") return;

    let message = {
      sender:AuthService.user.email,
      receipient:this.getRecepientName(),
      content: this.input.nativeElement.value,
      sentTime: new Date()
    } as MessageData;

    this.messages.push(message);

    this.chatService.sendMessage(message, this.data.cID).subscribe(
      res=>{
        message = res;
      }
    );

    this.input.nativeElement.value="";
    setTimeout(() => {
      this.scrollBottom();
    }, 0);
  }

  getRecepientName():string{
    return this.data.receipient == AuthService.user.email? this.data.sender : this.data.receipient;
  }

  scrollBottom():void{
    this.scroll.nativeElement.scrollTop = this.scroll.nativeElement.scrollHeight;
  }
}
