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
    getAllTags(): Observable<Event[]> {
        // console.log("test")
        
        return this.http.get("http://localhost:8084/event/all") as Observable<Event[]>;

        


    }

    getNumGuests(id:number): Observable<number> {
        // console.log("test")
        
        return this.http.get("http://localhost:8084/event/" + id + "/numGuests") as Observable<number>;

        


    }

}