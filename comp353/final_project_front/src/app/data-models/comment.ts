
export class Comment {

    public commentId : string;
    public content : string;
	public p_date : string;
    public authorEmail : string;
    public postId: string;

    constructor(id: string, content: string, p_date: string, email: string, postId: string) {
        this.commentId = id; 
        this.content = content;
        this.p_date = p_date;
        this.authorEmail = email;
        this.postId = postId;
    }
}  