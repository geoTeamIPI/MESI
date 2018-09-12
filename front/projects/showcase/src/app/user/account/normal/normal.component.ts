import { Component, OnInit } from '@angular/core';
import { User } from "../../../models/user.model";

@Component({
  selector: 'app-normal',
  templateUrl: './normal.component.html',
  styleUrls: ['./normal.component.css']
})
export class NormalComponent implements OnInit {
  isAdmin: boolean = false;
  currentUser: User;

  constructor() { }

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
  } 

}
