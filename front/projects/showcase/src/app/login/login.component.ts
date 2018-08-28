import { Component, OnInit } from '@angular/core';

import { AuthenticationService } from "../services/authentication.service";
import { User } from "../models/user.model";
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any = {}; 
  currentUser: User; 
  submitted: boolean = false; 
  invalidLogin: boolean; 

  constructor(private authenticationService: AuthenticationService, private router: Router) {
  }

  ngOnInit() {
    this.submitted = false; 
  }

  onSubmit() {
    this.submitted = true;
    this.login();
  }

  login(){
    this.authenticationService.login(this.user.email, this.user.password)
      .subscribe(user => {
        this.invalidLogin = false;
        this.router.navigate(["/"]);
        location.reload();
        }, err => { 
          console.log(err);
          this.invalidLogin = true; 
        });
  }
}
