import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { htmlAstToRender3Ast } from '@angular/compiler/src/render3/r3_template_transform';
import { HttpClient } from '@angular/common/http'; // keep these here for now.


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  lat = 32.7299; //these get dynamically updated every time the user clicks the page.
  lng = -97.1140;

  centerlat = this.lat; //center of the map. never changes.
  centerlng = this.lng;

  htmlStr: any;

  latStr: any; //lat and long for output purposes, may remove later
  longStr: any;


  readonly ROOT_URL = ''

  //have to include service in constructor to use its functions
  constructor(private es: EventService) { }

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


  searchInput(event) {
    this.es.getAllTags().subscribe(
      /**
       * When working with observables, we have access to two callback functions: one that executes in case of success and another that executes in case of failure.
       */
      data => {
        this.data = data;
        console.log(this.data);
      },
      error => {
        error = "Sorry. Couldn't get those tags!"
        console.log(error);
      }

    )

    let searchBar = (<HTMLInputElement>document.getElementById("searchBar")).value;

    this.htmlStr = searchBar;
   

    // this.es.getAllTags();



  }

}