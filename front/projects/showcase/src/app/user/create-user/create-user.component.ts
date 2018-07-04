import { Component, OnInit } from "@angular/core";

import { User } from "../../models/user.model";
import { UserService } from "../../services/user.service";
import { HttpClient } from "@angular/common/http";
import { NgForm } from "@angular/forms";

@Component({
  selector: "create-user",
  templateUrl: "./create-user.component.html",
  styleUrls: ["./create-user.component.css"]
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  submitted = false;
  constructor(private userService: UserService) {}

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];
  selectedValue = this.profiles[0].id; 

  ngOnInit() {}

  newUser(): void {
    this.submitted = false;
    this.user = new User();
  }

  createUser() {
    this.userService
      .createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
  }

  onSubmit() {
    this.submitted = true;
    this.createUser();
  }
}
