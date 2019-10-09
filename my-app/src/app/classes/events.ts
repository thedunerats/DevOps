export class Event {


    public id: number = 0;
    public eventName: string;
    public eventDescription: string;
    public eventStartDate: string;
    public eventEndDate: string;
    public latitude: number;
    public longitude: number;
    public eventOwner: string;
    //Must use the constructor keyword.
    constructor(event_id: number, event_name: string, event_description: string, event_start_date: string, event_end_date: string, latitude: number, longitude: number, event_owner: string) {
        this.id = event_id;
        this.eventName = event_name;
        this.eventDescription = event_description;
        this.eventStartDate = event_start_date;
        this.eventEndDate = event_end_date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.eventOwner = event_owner;
    }

    public getId(id:any, someString:string){
        return this.id;
    }
}