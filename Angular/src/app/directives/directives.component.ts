import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/services/event.service'
@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css']
})
export class DirectivesComponent implements OnInit {

  constructor(private es: EventService) { }

  ngOnInit() {
    this.getAllTags();
  }

  data: string[] = [];

  getAllTags() {
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
  }


}
