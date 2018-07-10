import { Component, OnInit } from "@angular/core";

import { User } from "../../models/user.model";
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";

@Component({
  selector: "create-user",
  templateUrl: "./create-user.component.html",
  styleUrls: ["./create-user.component.css"]
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  submitted = false;
  hideProfile = false;  

  constructor(private userService: UserService, private route: Router) {}

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];
  selectedValue = this.profiles[0].id; 

  ngOnInit() {
    if (this.route.url.includes("/registering")){
        this.hideProfile = true; 
    }
  }

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  createUser() {
    this.userService
      .createUser(this.user)
      .subscribe(data => this.submitted = true, error => console.log(error));
    this.user = new User();
  }

  onSubmit() {
    this.createUser();
  }


}
