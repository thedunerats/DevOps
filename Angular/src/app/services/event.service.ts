import { Event } from './../classes/events';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';


//need to use functions of one class in another. 
@Injectable({
    providedIn: 'root'
})


export class EventService {


    constructor(private http: HttpClient) { }

    getAllTags(): Observable<Event[]> {
        return this.http.get("http://localhost:8084/event/all") as Observable<Event[]>;
    }
}