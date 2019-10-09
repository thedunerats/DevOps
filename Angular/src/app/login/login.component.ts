import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { User } from '../classes/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private us:UserService) { }

  ngOnInit() {
  }

  username:string;
  password:string;
  private passedUser:User = new User();
  private returnedUser:User = new User();

  usernameFocusout(event){
    this.username = event.target.value;
  }
  passwordFocusout(event){
    this.password=event.target.value;
  }

  login(){
    this.passedUser.setUsername(this.username);
    this.passedUser.setPassword(this.password);
    this.us.login(this.passedUser).subscribe(
      data => {
        this.returnedUser = data;
      },
      error => {
        console.log("An error occured while logging in.")
      }
    );
    if(this.returnedUser != null){

    }
    else{
      let invalid = document.getElementById("login-failed");
      invalid.style.display = "block";
    }
  }
}