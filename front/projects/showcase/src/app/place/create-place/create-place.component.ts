import { Component, OnInit } from "@angular/core";

import { Place } from "../../models/place.model";
import { User } from "../../models/user.model";
import { PlaceService } from "../../services/place.service";
import { Router } from "@angular/router";
import { FormGroup, FormControl, Validators, AbstractControl, ValidatorFn, ValidationErrors } from '@angular/forms';

@Component({
  selector: "create-place",
  templateUrl: "./create-place.component.html",
  styleUrls: ["./create-place.component.css"]
})
export class CreatePlaceComponent implements OnInit {
  place: Place = new Place();
  submitted: boolean = false;
  placeCreated: boolean;  
  placeForm : FormGroup;
  longitude : FormControl; 
  latitude: FormControl; 
  numberstreet: FormControl;
  street: FormControl;
  zipcode: FormControl; 
  city: FormControl;
  currentUser: User; 

  constructor(private placeService: PlaceService) {}

  ngOnInit() {
  }

  createPlace() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    this.placeService
      .createPlace(this.place, this.currentUser.id)
      .subscribe(data => this.placeCreated = true, error => this.placeCreated = false);
    this.place = new Place();
  }

  onSubmit() {
    this.createPlace();
    this.submitted = true; 
  }
}