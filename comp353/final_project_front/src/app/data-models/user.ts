export class User {
    public fname : string;
    public lname : string;
    public mname : string;
    public userId: string; 

    constructor(fname: string, lname: string, mname: string, userId: string) { 
        this.fname = fname;
        this.lname = lname; 
        this.mname = mname;
        this.userId = userId;
    }
}  