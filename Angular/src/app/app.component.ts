import { Component, Inject } from '@angular/core';
import { WebStorageService, SESSION_STORAGE } from 'angular-webstorage-service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-app';
  lat = 32.7299;
  lng = -97.1140;
  constructor(@Inject(SESSION_STORAGE) private storage:WebStorageService){}
}

