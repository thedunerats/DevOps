import { Component, OnInit, Inject } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../classes/user';
import { NgForm } from '@angular/forms'
import { SESSION_STORAGE, WebStorageService } from 'angular-webstorage-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private us:UserService,@Inject(SESSION_STORAGE)private storage:WebStorageService) { }

  ngOnInit() {
  }

  //The passedUser represents the data being entered
  //passedUser will be passed to the Java backend to be
  //found in the database.
  private passedUser:User = new User();

  //The data returned by the backend is stored in the
  //returnedUser.
  private returnedUser:User = null;

  login(form:NgForm){
    this.passedUser.setUsername(form.value["username"]);
    this.passedUser.setPassword(form.value["password"]);
    this.us.login(this.passedUser).subscribe(
      data => {
        this.returnedUser = data;
        console.log("Data " + data);
        
        //If the data entered was not found, display a message prompting
        //the user to re-input form data.
        if(this.returnedUser != null){
          let invalid = document.getElementById("login-failed");
          invalid.style.display = "none";
          this.storage.set("username",this.returnedUser.getUsername());
          this.storage.set("userrole",this.returnedUser.getUserRoleId());
          this.storage.set("loggedIn",true);
        }
        else{
          let invalid = document.getElementById("login-failed");
          invalid.style.display = "block";
          form.resetForm();
        }
      },
      error => {
        console.log("An error occured while logging in.")
      }
    );
  }
}