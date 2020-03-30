export class Post {

    public id : string;
    public url : string;
    public content : string;
    public date : string;
    public isCommentable : boolean;
    public isPublic : boolean; 
    public groupId : string;
    public authorId : string;

    constructor(id: string, url: string, content: string, date: string, 
        isCom: boolean, isPub: boolean, groupId: string,authorId: string ) { 
        this.id = id;
        this.url = url; 
        this.content = content;
        this.date = date;
        this.isCommentable = isCom;
        this.isPublic = isPub; 
        this.groupId = groupId;
        this.authorId = authorId;
    }
}  