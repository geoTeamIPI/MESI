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
  placeForm: FormGroup;
  longitude: FormControl;
  latitude: FormControl;
  numberstreet: FormControl;
  street: FormControl;
  zipcode: FormControl;
  city: FormControl;
  currentUser: User;
  isAdmin: string = "notConnected";
  passageparmap: boolean = false;
  temp: string;
  urlStory: string;
  idJustCreated: number; 
  idPlace: string; 

  constructor(private placeService: PlaceService, private router: Router) { }

  ngOnInit() {
    this.place.longitude = JSON.parse(sessionStorage.getItem("longitude") || '{}');
    this.place.latitude = JSON.parse(sessionStorage.getItem("latitude") || '{}');
    this.temp = JSON.parse(sessionStorage.getItem("passageparmap") || '{}');
    if (this.temp == "passageparmap") {
      this.passageparmap = true;
    } else {
      this.passageparmap = false;
    }
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = "admin";
      this.urlStory = "/account/admin/stories/add";
    } else if (this.currentUser.profile == "user") {
      this.isAdmin = "user";
      this.urlStory = "/account/user/stories/add";
    }
  }

  createPlace() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    this.placeService
      .createPlace(this.place, this.currentUser.id)
      .subscribe(data => this.placeCreated = true, error => this.placeCreated = false);
    this.place = new Place();
    this.getIdJustCreated();
    //sessionStorage.setItem('idPlace', JSON.stringify(this.idJustCreated));
    //console.log("idPLace vaut = " + this.idJustCreated);
  }

  onSubmit() {
    this.createPlace();
    this.submitted = true;
    if (this.passageparmap == true) {
      console.log("je suis passé dedans");
      this.router.navigate([this.urlStory]);
    }
  }

  getIdJustCreated() {
    this.placeService.findByCoordinates(this.place.longitude, this.place.latitude)
      .toPromise()
      .then(
        idJustCreated => {
          this.idJustCreated = idJustCreated;
        }
      );
      console.log("id just created depuis create place component = " + this.idJustCreated);
  }
}