import { Component, OnInit } from '@angular/core';
import { User } from "../../../models/user.model";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
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
 