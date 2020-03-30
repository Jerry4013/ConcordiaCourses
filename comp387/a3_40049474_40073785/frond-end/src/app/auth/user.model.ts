export class UserModel {
  public id: number;
  public username: string;
  public password: string;
  public sessionId: string;


  constructor(id: number, username: string, password: string, sessionId: string) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.sessionId = sessionId;
  }
}
