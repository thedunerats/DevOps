import { Component, OnInit, Inject } from '@angular/core';
import { EventService } from '../services/event.service';
import { Event } from 'src/app/classes/events';
import { SESSION_STORAGE, WebStorageService } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { GuestService } from '../services/guest.service';
import { Guest } from '../classes/guest';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  lat = 32.7299;
  lng = -97.1140;
  data: Event[] = [];
  htmlStr: any;
  numberOfGuests: number;
  openedWindow: string;
  attendingBool: boolean = true;

  constructor(private es: EventService,
    private gs: GuestService,
    @Inject(SESSION_STORAGE) private storage:WebStorageService,
    private router:Router) { }

  ngOnInit() {
  }

  searchInput() {
    this.es.getAllEvents().subscribe(
      data => {
        this.data = data;
      },
      error => {
        error = "Sorry. Couldn't get those tags!"
        console.log(error);
      }
    );
    this.htmlStr = (<HTMLInputElement>document.getElementById("searchBar")).value;

    if(this.htmlStr==="") {
      this.closeWindow();
    }
  }

  openWindow(eventname, eventid) {
    this.openedWindow = eventname;
    this.es.getNumGuests(eventid).subscribe(
      data => {
        this.numberOfGuests = data;
      },
      error => {
        error = "Sorry. Couldn't get those tags!"
        console.log(error);
      }
    );
    this.gs.findGuest(eventid,this.storage.get("userid")).subscribe(
      data => {
        let guestCheck = data;
        if(guestCheck != null) {
          this.attendingBool = false;
        }
        else {
          this.attendingBool = true;
        }
      }
    );
    
  }

  isInfoWindowOpen(eventname) {
    return this.openedWindow == eventname;
  }

  closeWindow() {
    return this.openedWindow = "";
  }

  
  attending(eventid) {
    if(this.storage.get("loggedIn") === "true") {
      let newGuest:Guest = new Guest(eventid, this.storage.get("userid"));
      this.gs.addGuest(newGuest).subscribe();
      this.attendingBool = false;
    }
    else {
      this.router.navigate(['app-login']);
    }
  }
  notAttending(eventid) {
    if(this.storage.get("loggedIn") === "true") {
      let newGuest:Guest = new Guest(eventid, this.storage.get("userid"));
      this.gs.removeGuest(newGuest).subscribe();
      this.attendingBool = true;
    }
    else {
      this.router.navigate(['app-login']);
    }
  }
}
