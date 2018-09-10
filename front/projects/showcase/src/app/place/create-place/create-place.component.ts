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
  placeCreated: String;  
  placeForm : FormGroup;
  longitude : FormControl; 
  latitude: FormControl; 
  numberstreet: FormControl;
  street: FormControl;
  zipcode: FormControl; 
  city: FormControl;
  currentUser: User; 

  constructor(private placeService: PlaceService, private route: Router) {}

  ngOnInit() {
    this.controlFormPlace();
    this.createFormPlace();
  }

  createPlace() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    this.placeService
      .createPlace(this.place, this.currentUser.id)
      .subscribe(data => console.log(data), error => console.log(error));
    this.place = new Place();
  }

  onSubmit() {
    if (this.placeForm.valid){
      this.createPlace();
      this.placeForm.reset();
    }
    this.submitted = true; 
  }

  controlFormPlace(){
    this.longitude = new FormControl('', [
      Validators.required
    ]);
    this.latitude = new FormControl('', [
      Validators.required
    ]);
}

createFormPlace(){
  this.placeForm  = new FormGroup({
    longitude : this.longitude,
    latitude: this.latitude,
    numberstreet: this.numberstreet,
    street: this.street,
    zipcode: this.zipcode,
    city: this.city
  });
}
}