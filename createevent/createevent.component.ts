import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event.service';
import { htmlAstToRender3Ast } from '@angular/compiler/src/render3/r3_template_transform';
import { NgForm } from '@angular/forms'
import { WebStorageService, SESSION_STORAGE } from 'angular-webstorage-service';
import { Router } from '@angular/router';
import { Event } from '../classes/events';
// keep these here for now.

@Component({
  selector: 'app-createevent',
  templateUrl: './createevent.component.html',
  styleUrls: ['./createevent.component.css']
})
export class CreateeventComponent implements OnInit {

  constructor(private es:EventService, @Inject(SESSION_STORAGE) private storage:WebStorageService, private router:Router) { }


  lat = 32.7299; //these get dynamically updated every time the user clicks the page.
  lng = -97.1140;

  centerlat = this.lat; //center of the map. never changes.
  centerlng = this.lng;

  htmlStr: any;

  latStr: any; //lat and long for output purposes, may remove later
  longStr: any;

  readonly ROOT_URL = ''

  eName: any;
  eTag: any;
  eDesc: any;

  eBegin: any; 
  eEnd: any;

  data: string[] = []; 

  ngOnInit() {

  }

  map = document.getElementById('map'); //initializes map on the back end, used event binding on front to do so.

  getLatAndLong(event){ // gets latitude and longitude from a map click
    this.latStr = event.coords.lat;
    this.longStr = event.coords.lng;
    //update the marker with the clicked coordinates
    this.lat = event.coords.lat;
    this.lng = event.coords.lng;
  }
   
  //createEvent, make the DB call
   //The passedUser represents the data being entered
  //passedUser will be passed to the Java backend to be
  //found in the database.
  private passedEvent:Event = new Event();

  //The data returned by the backend is stored in the
  //returnedUser.
  private returnedEvent:Event = null;

  createEvent(form:NgForm){
    this.passedEvent.setEventName(form.value["username"]);
    this.passedEvent.setEventDescription(form.value["eventdescription"]);
    this.passedEvent.setStartDate(form.value["startTime"]);
    this.passedEvent.setEndDate(form.value["endTime"]);
    this.passedEvent.setLatitude(this.lat);
    this.passedEvent.setLongitude(this.lng);
    this.es.createEvent(this.passedEvent).subscribe(
      data => {
        this.returnedEvent = data;
        console.log("Data " + data);
        
        //If the data entered was not found, display a message prompting
        //the user to re-input form data.
        if(this.returnedEvent != null){
          this.router.navigate(['app-search']);
        }
        else{
          form.resetForm();
          alert("Hang on a second. We couldn't process your event. Try again, please?");
        }
      },
      error => {
        console.log("An error occured while creating your event.")
      }
    );
  }



  }