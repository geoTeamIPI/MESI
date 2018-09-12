import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../models/user.model';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-registering-account',
  templateUrl: './registering-account.component.html',
  styleUrls: ['./registering-account.component.css']
})
export class RegisteringAccountComponent implements OnInit {

  user: User = new User();
  submitted: boolean = false;
  pwdMatched: boolean; 
  userCreated: boolean;  
  userForm : FormGroup;
  nickname: FormControl; 
  email : FormControl; 
  password: FormControl; 
  city: FormControl;
  passwordConfirm: FormControl;
  
  constructor(private userService: UserService) {}

  ngOnInit() {
    this.controlFormUser();
    this.createFormUser();
  }

  registeringAccount() {
    this.userService
      .registeringAccount(this.user)
      .subscribe(data => this.userCreated = true, error => this.userCreated = false);  }

  onSubmit() {
    this.submitted = true;
    if (this.userForm.valid){
      this.registeringAccount();
      this.userForm.reset();
    }
  }

  controlFormUser(){
    this.nickname = new FormControl('', [
      Validators.required
    ]);
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
}

createFormUser(){
  this.userForm  = new FormGroup({
    nickname: this.nickname, 
    email: this.email, 
    password: this.password, 
    city: this.city, 
    passwordConfirm: this.passwordConfirm
  });
}

}
