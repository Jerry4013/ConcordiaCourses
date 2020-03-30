export class EmailModel {
  public id: number;
  public title: string;
  public sender: string;
  public recipient: string;
  public content: string;


  constructor(id: number, title: string, sender: string, recipient: string, content: string) {
    this.id = id;
    this.title = title;
    this.sender = sender;
    this.recipient = recipient;
    this.content = content;
  }
}
