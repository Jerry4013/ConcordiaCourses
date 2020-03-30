import { Component, OnInit, Inject } from '@angular/core';
import { ChatState } from '../../models/chat-state';
import { ChatServiceService } from 'src/app/services/chat/chat-service.service';
import { ChatRequest } from 'src/app/data-models/chatRequest';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { AuthService } from 'src/app/services/auth/auth.service';

@Component({
  selector: 'app-chat-window',
  templateUrl: './chat-window.component.html',
  styleUrls: ['./chat-window.component.scss']
})
export class ChatWindowComponent implements OnInit {

  headerMessage = "Chats";

  chatCapsules:ChatState[];

  constructor(
    private chatService: ChatServiceService,
    private dialog: MatDialog,
    private authService: AuthService) { }

  ngOnInit() {

    this.fetchChatStates();

    this.chatService.messagePublisher.subscribe(
      data=>{
        let found =false;
        this.chatCapsules.forEach(
          ele=>{
            if(ele.cID == data.chatID) found = true;
          }
        );

        if(!found){
          this.chatService.getAllChats(AuthService.user.email).subscribe(
            result=>{
              this.chatCapsules = result;
            }
          );
        }
      }
    )
  }

  createChat():void{
    const dialogRef = this.dialog.open(CreateChatDialog, {
      width: '250px',
      data: {email:""}
    });

    dialogRef.afterClosed().subscribe(result => {

      if(result == AuthService.user.name){
        alert("Cannot chat with yourself!");
        return;
      }

      this.chatService.createChat(
        {
          sender: AuthService.user.email,
          receipient: result,
          sentTime: new Date()
        } as ChatRequest
      ).subscribe(
        res=>{
          this.fetchChatStates();
        },
        err=>{
          alert(err.error);
        }
      )
    });
  }

  fetchChatStates():void{
    this.chatService.getAllChats(AuthService.user.email).subscribe(
      result=>{
        this.chatCapsules = result;

        this.chatCapsules.sort((a,b)=>b.cID-a.cID);
      }
    );
  }
}

@Component({
  selector: 'dialog-overview-example-dialog',
  templateUrl: 'chat-create-dialog.html',
})
export class CreateChatDialog {

  constructor(
    public dialogRef: MatDialogRef<CreateChatDialog>,
    @Inject(MAT_DIALOG_DATA) public data: any) {}

  onNoClick(): void {
    this.dialogRef.close();
  }
}
