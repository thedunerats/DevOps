import { Component, OnInit, Inject } from '@angular/core';
import { SESSION_STORAGE, WebStorageService } from 'angular-webstorage-service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private loggedIn:boolean;

  constructor(@Inject(SESSION_STORAGE) private storage:WebStorageService){

  }

  ngOnInit() {
    this.loginOrLogout();
  }

  loginOrLogout() {
    if(this.storage.get("loggedIn") == true){
      this.loggedIn = true;
    }
    else {
      this.loggedIn = false;
    }
  }

}
