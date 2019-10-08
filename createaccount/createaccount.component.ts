import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-createaccount',
  templateUrl: './createaccount.component.html',
  styleUrls: ['./createaccount.component.css']
})
export class CreateaccountComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }


 showClubRegistration(){

  var y = document.getElementById("club_text");
  y.style.visibility = "hidden"; // make hidden initially
  //FIXME: will not work when pasted outside the function. Expects a constructor.

if (y.style.visibility === "hidden"){
  y.style.visibility = "visible";
}  else {
  y.style.visibility = "hidden";
  } // this might be the fix. 

}  

}
