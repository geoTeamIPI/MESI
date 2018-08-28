import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'showcase-form-controls',
  templateUrl: './form-controls.component.html',
  styleUrls: ['./form-controls.component.css']
})
export class FormControlsComponent implements OnInit {

  userForm : FormGroup;
  email : FormControl; 
  password: FormControl; 
  city: FormControl; 
  passworConfirm: FormControl; 


  constructor() { }

  ngOnInit() {
    this.controlFormUser(); 
    this.createFormUser(); 
  }

  controlFormUser(){
      this.email =  new FormControl('', [
        Validators.email,
        Validators.minLength(3), 
        Validators.required]);
      this.password =  new FormControl('', [
        Validators.required
      ]);
      this.passworConfirm = new FormControl('', [
        Validators.required
      ])
      this.city = new FormControl('', [
        Validators.required
      ]);
  }

  createFormUser(){
    this.userForm  = new FormGroup({
      email: this.email, 
      password: this.password, 
      city: this.city
    });
  }

}
