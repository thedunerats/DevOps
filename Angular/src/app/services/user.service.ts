import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';
import { User } from '../classes/user';

const API_URL = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  login(user:User):Observable<User> {
    return this.http.post(API_URL + "/login",user) as Observable<User>;
  }

  signup(user:User):Observable<User> {
    return this.http.post(API_URL + "/signup",user) as Observable<User>;
  }
}
