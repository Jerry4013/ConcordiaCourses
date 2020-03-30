export class GroupModel {
  public groupId: number;
  public eventID: number;
  public owner_email: string;
  public title: string;


  constructor(groupId: number, eventID: number, owner_email: string, title: string) {
    this.groupId = groupId;
    this.eventID = eventID;
    this.owner_email = owner_email;
    this.title = title;
  }
}
