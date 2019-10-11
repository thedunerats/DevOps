import { Event } from './../classes/events';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

const API_URL = environment.apiUrl;

//need to use functions of one class in another. 
@Injectable({
    providedIn: 'root'
})


export class EventService {


    constructor(private http: HttpClient) { }

    getAllEvents(): Observable<Event[]> {
        return this.http.get(API_URL + "/event/all") as Observable<Event[]>;
    }

    getNumGuests(id:number): Observable<number> {
        return this.http.get(API_URL + "/event/" + id + "/numGuests") as Observable<number>;
    }

    createEvent(event:Event):Observable<Event> {
        return this.http.post(API_URL + "/event/insert",event) as Observable<Event>;
    }
}