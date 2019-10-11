export class Guest {
    private eventid:number;
    private userid:number;

    constructor(event_id:number,user_id:number) {
        this.eventid = event_id;
        this.userid = user_id;
    }
}