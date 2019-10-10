export class Event {


    public id: number;
    public eventname: string;
    public eventdescription: string;
    public eventstartdate: string;
    public eventenddate: string;
    public latitude: number;
    public longitude: number;
    public eventowner: string;
   
    //Must use the constructor keyword.
    constructor(event_id: number, event_name: string, event_description: string, event_start_date: string, event_end_date: string, latitude: number, longitude: number, event_owner: string) {
        this.id = event_id;
        this.eventname = event_name;
        this.eventdescription = event_description;
        this.eventstartdate = event_start_date;
        this.eventenddate = event_end_date;
        this.latitude = latitude;
        this.longitude = longitude;
        this.eventowner = event_owner;
    }


}