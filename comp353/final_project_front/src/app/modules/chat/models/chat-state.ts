import { MessageData } from './MessageData';

export class ChatState{
    cID:number;
    mID:string;
    lastMessageID: MessageData;
    sender:string;
    receipient:string;
    content:string;
    sentTime:string;
}