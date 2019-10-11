export class Event {


    public id: number = 0;
    public eventName: string;
    public eventDescription: string;
    public eventStartDate: string;
    public eventEndDate: string;
    public latitude: number;
    public longitude: number;
    public eventOwner: number;
    //Must use the constructor keyword.
    constructor(){}
    
    public setId(id:number) {
        this.id = id;
    }
    public setEventName(eventName:string) {
        this.eventName = eventName;
    }
    public setEventDescription(event_description:string) {
        this.eventDescription = event_description;
    }
    public setStartDate(event_start_date:string) {
        this.eventStartDate = event_start_date;
    }
    public setEndDate(event_end_date:string) {
        this.eventEndDate = event_end_date;
    }
    public setLatitude(latitude:number) {
        this.latitude = latitude;
    }
    public setLongitude(longitude:number) {
        this.longitude = longitude;
    }
    public setEventOwner(event_owner:number) {
        this.eventOwner = event_owner;
    }
}