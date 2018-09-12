import { Component, OnInit } from "@angular/core";

import { Timelapse } from "../../models/timelapse.model";
import { User } from "../../models/user.model";
import { TimelapseService } from "../../services/timelapse.service";
import { Router } from "@angular/router";
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn, ValidationErrors } from '@angular/forms';

@Component({
  selector: "create-timelapse",
  templateUrl: "./create-timelapse.component.html",
  styleUrls: ["./create-timelapse.component.css"]
})
export class CreateTimelapseComponent implements OnInit {
  timelapse: Timelapse = new Timelapse();
  submitted: boolean = false;
  timelapseCreated: String;  
  timelapseForm : FormGroup;
  period : FormControl; 
  startingYear: FormControl; 
  endingYear: FormControl;
  comments: FormControl;
  isapproved: FormControl; 
  logo: FormControl;
  color: FormControl;
  currentUser: User; 
  isAdmin: boolean = false; 
  

  constructor(private timelapseService: TimelapseService, private route: Router) {}

  ngOnInit() {
    this.controlFormTimelapse();
    this.createFormTimelapse();
  }

  createTimelapse() {
    this.timelapseService
      .createTimelapse(this.timelapse, this.currentUser.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.timelapse = new Timelapse();
  }

  onSubmit() {
    if (this.timelapseForm.valid){
      this.createTimelapse();
      this.timelapseForm.reset();
    }
    this.submitted = true; 
  }

  controlFormTimelapse(){
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    }
    this.period = new FormControl('', [
      Validators.required
    ]);
    this.startingYear = new FormControl('', [
      Validators.required
    ]);
}

createFormTimelapse(){
  this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
  if (this.currentUser.profile == "admin"){
    this.isAdmin = true;
  } else{
    this.isAdmin = false;
  }
  this.timelapseForm  = new FormGroup({
    period : this.period,
    startingYear: this.startingYear,
    endingYear: this.endingYear,
    comments: this.comments,
    isapproved: this.isapproved,
    logo: this.logo
  });
}
}