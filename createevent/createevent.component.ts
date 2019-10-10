import { Component, OnInit } from '@angular/core';
import { htmlAstToRender3Ast } from '@angular/compiler/src/render3/r3_template_transform';
import { HttpClient } from '@angular/common/http'; // keep these here for now.

@Component({
  selector: 'app-createevent',
  templateUrl: './createevent.component.html',
  styleUrls: ['./createevent.component.css']
})
export class CreateeventComponent implements OnInit {

  constructor() { }





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
  eBegin: string;

  data: string[] = []; 

  ngOnInit() {
    // use ngmodel to populate the info window. either that or ngfor.
    

  }

  map = document.getElementById('map'); //initializes map on the back end, used event binding on front to do so.

  getLatAndLong(event){ // gets latitude and longitude from a map click
    this.latStr = event.coords.lat;
    this.longStr = event.coords.lng;
    //update the marker with the clicked coordinates
    this.lat = event.coords.lat;
    this.lng = event.coords.lng;
  }
   

    // this.es.getAllTags();



  }