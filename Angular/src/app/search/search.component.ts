import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event.service';
import { Event } from 'src/app/classes/events';

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

  constructor(private es: EventService) { }

  ngOnInit() {
  }

  searchInput() {
    this.es.getAllTags().subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      },
      error => {
        error = "Sorry. Couldn't get those tags!"
        console.log(error);
      }

    );
    let searchBar = (<HTMLInputElement>document.getElementById("searchBar")).value;

    this.htmlStr = searchBar;
  }
  clicking(event) {
    alert(event.target.id)
  };
}
