import { Component, OnInit } from "@angular/core";

import { Type } from "../../models/type.model";
import { User } from "../../models/user.model";
import { TypeService } from "../../services/type.service";
import { Router } from "@angular/router";
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn, ValidationErrors } from '@angular/forms';

@Component({
  selector: "create-type",
  templateUrl: "./create-type.component.html",
  styleUrls: ["./create-type.component.css"]
})
export class CreateTypeComponent implements OnInit {
  type: Type = new Type();
  submitted: boolean = false;
  typeCreated: String;  
  typeForm : FormGroup;
  name : FormControl; 
  comments: FormControl;
  isapproved: FormControl; 
  pathpicture: FormControl;
  logo: FormControl;
  currentUser: User; 
  isAdmin: boolean = false; 
  

  constructor(private typeService: TypeService, private route: Router) {}

  ngOnInit() {
    this.controlFormType();
    this.createFormType();
  }

  createType() {
    this.typeService
      .createType(this.type, this.currentUser.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.type = new Type();
  }

  onSubmit() {
    if (this.typeForm.valid){
      this.createType();
      this.typeForm.reset();
    }
    this.submitted = true; 
  }

  controlFormType(){
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    }
    this.name = new FormControl('', [
      Validators.required
    ]);
}

createFormType(){
  this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
  if (this.currentUser.profile == "admin"){
    this.isAdmin = true;
  } else{
    this.isAdmin = false;
  }
  this.typeForm  = new FormGroup({
    name : this.name,
    comments: this.comments,
    isapproved: this.isapproved,
    logo: this.logo,
    pathpicture: this.pathpicture
  });
}
}