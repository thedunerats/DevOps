import { EventService } from './../services/event.service';
import { Component, OnInit } from '@angular/core';
import { htmlAstToRender3Ast } from '@angular/compiler/src/render3/r3_template_transform';
import { HttpClient } from '@angular/common/http';
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


  readonly ROOT_URL = ''

  //have to include service in constructor 
  constructor(private es: EventService) { }

  data: Event[] = [];

  ngOnInit() {

  }



  searchInput(event) {
    this.es.getAllTags().subscribe(
      /**
       * When working with observables, we have access to two callback functions: one that executes in case of success and another that executes in case of failure.
       */
      data => {
        this.data = data;
        // console.log(this.data);
      },
      error => {
        error = "Sorry. Couldn't get those tags!"
        console.log(error);
      }

    )






    let searchBar = (<HTMLInputElement>document.getElementById("searchBar")).value;

    this.htmlStr = searchBar;






  }





  openedWindow: string;

  openWindow(eventname) {
    this.openedWindow = eventname;
  }

  isInfoWindowOpen(eventname) {

    return this.openedWindow == eventname;
  }
}



