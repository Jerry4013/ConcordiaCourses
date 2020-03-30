export class ResponseModel {
  public success: boolean;
  public msg: string;


  constructor(success: boolean, msg: string) {
    this.success = success;
    this.msg = msg;
  }
}
