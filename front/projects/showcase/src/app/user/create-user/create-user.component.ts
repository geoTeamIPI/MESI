import { Component, OnInit } from "@angular/core";

import { User } from "../../models/user.model";
import { UserService } from "../../services/user.service";
import { Router } from "@angular/router";
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: "create-user",
  templateUrl: "./create-user.component.html",
  styleUrls: ["./create-user.component.css"]
})
export class CreateUserComponent implements OnInit {
  user: User = new User();
  submitted: boolean = false;
  hideProfile = false;
  userCreated: String;  
  userForm : FormGroup;
  email : FormControl; 
  password: FormControl; 
  city: FormControl;
  passwordConfirm: FormControl;
  profile: FormControl; 

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
    this.controlFormUser();
    this.createFormUser(); 
  }

  createUser() {
    this.userService
      .createUser(this.user)
      .subscribe(data => console.log(data), error => console.log(error));
    this.user = new User();
  }

  onSubmit() {
    if (this.userForm.valid){
      this.createUser();
      this.userForm.reset();
    }
    this.submitted = true; 

  }

  controlFormUser(){
    this.email =  new FormControl('', [
      Validators.email,
      Validators.minLength(7), 
      Validators.required]);
    this.password =  new FormControl('', [
      Validators.required
    ]);
    this.city = new FormControl('', [
      Validators.required
    ]);
    this.passwordConfirm = new FormControl('', [
      Validators.required
    ]);
    this.profile = new FormControl('', [
      Validators.required
    ]);
}

createFormUser(){
  this.userForm  = new FormGroup({
    email: this.email, 
    password: this.password, 
    city: this.city, 
    passwordConfirm: this.passwordConfirm, 
    profile: this.profile
  });
}


}
