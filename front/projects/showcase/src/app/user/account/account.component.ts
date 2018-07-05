import { Component, OnInit } from '@angular/core';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  currentUser: User; 

  constructor() { }

  ngOnInit() {
    this.currentUser = JSON.parse(localStorage.getItem("currentUser")); 
  }

}
