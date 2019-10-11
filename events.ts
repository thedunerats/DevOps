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
    constructor() {}
    
 event_owner: string

    public getId(){return this.id;}
    public setId(id:number){this.id = id;}

    public getEventName(){return this.eventName;}
    public setEventName(eventName:string){this.eventName = eventName;}
    
    public getEventDescription(){return this.eventDescription;}
    public setEventDescription(eventDescription:string){this.eventDescription = eventDescription;}

    public getStartDate(){return this.eventStartDate;}
    public setStartDate(eventStartDate:string){this.eventStartDate = eventStartDate;}

    public getEndDate(){return this.eventEndDate}
    public setEndDate(eventEndDate:string){this.eventEndDate = eventEndDate;}

    public getLatitude(){return this.latitude}
    public setLatitude(latitude:number){this.latitude = latitude;}

    public getLongitude(){return this.longitude}
    public setLongitude(longitude:number){this.longitude = longitude;}

    public getEventOwner(){return this.eventOwner}
    public setEventOwner(eventOwner:string){this.eventOwner = eventOwner;}
        

    
}