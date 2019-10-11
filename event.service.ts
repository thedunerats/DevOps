import { Tag } from './../classes/tags';
import { Event } from './../classes/events';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';


//need to use functions of one class in another. 
@Injectable({
    providedIn: 'root'
})


export class EventService {


    constructor(private http: HttpClient) { }

    //Observable<Tag[]>
    getAllTags(): Observable<string[]> {
        console.log("test")
        
        return this.http.get("http://localhost:8080/event/1/tags") as Observable<string[]>;

    }

    // create a new event: makes a call to backend / db
    createEvent(event:Event):Observable<Event> {
        return this.http.post("http://localhost:8090/event/insert", event) as Observable<Event>;
      }
    

    

}