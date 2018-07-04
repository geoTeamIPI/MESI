import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-update-account',
  templateUrl: './update-account.component.html',
  styleUrls: ['./update-account.component.css']
})
export class UpdateAccountComponent implements OnInit {

  user: User;
  currentUser: User; 

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUser();
  }

  onSubmit(){
    this.userService.updateAccount(this.user.email, this.user)
      .subscribe(data => {
        console.log(data); 
      }, err => {
        console.log(err); 
      })
  }

  getUser(){
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
    this.userService.getAccount(this.currentUser.email)
      .subscribe(data => {
        this.user = data;
        this.user.password = null; 
        console.log(this.user); 
      }, err => {
        console.log(err); 
      });
  }

}