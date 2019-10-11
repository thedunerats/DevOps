import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Guest } from '../classes/guest';
import { environment } from 'src/environments/environment';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class GuestService {

  constructor(private http: HttpClient) { }

  

  findGuest(eventid:number,userid:number):Observable<Guest> {
    return this.http.get(API_URL + "/guest/findGuest?eventid=" + eventid + "&userid=" + userid) as Observable<Guest>;
  }

  addGuest(guest:Guest):Observable<boolean> {
      return this.http.post(API_URL + "/guest/insertGuest",guest) as Observable<boolean>;
  }
  removeGuest(guest:Guest):Observable<boolean> {
      return this.http.post(API_URL + "/guest/removeGuest",guest) as Observable<boolean>;
  }
}
