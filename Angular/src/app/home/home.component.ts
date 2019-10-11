import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { Event } from 'src/app/classes/events';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  lat = 32.7299;
  lng = -97.1140;
  htmlStr: any;
  centerlat = 32.7299;
  centerlng = -97.1140;
  latStr: any;
  longStr: any;
  map = document.getElementById('map');

  readonly ROOT_URL = '';

  //have to include service in constructor 
  constructor() { }

  ngOnInit() {
  }

  getLatAndLong(event){ // gets latitude and longitude from a map click
    this.latStr = event.coords.lat;
    this.longStr = event.coords.lng;
    //update the marker with the clicked coordinates
    this.lat = event.coords.lat;
    this.lng = event.coords.lng;
  }
}