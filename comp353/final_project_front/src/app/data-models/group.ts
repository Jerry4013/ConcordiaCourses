export class Group {

    public groupId : string;
    public eventId : string;
	public ownerId : string;
    public title : string;

    constructor(gId: string, eId: string, ownId: string, title: string) { 
        this.groupId = gId;
        this.eventId = eId; 
        this.ownerId = ownId;
        this.title = title;
    }
}  