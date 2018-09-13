import { Component, OnInit } from "@angular/core";

import { User } from "../../models/user.model";
import { UserService } from "../../services/user.service";
import { Type } from "../../models/type.model";
import { TypeService } from "../../services/type.service";
import { Story } from "../../models/story.model";
import { Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Place } from "../../models/place.model";
import { PlaceService } from "../../services/place.service";
import { Timelapse } from "../../models/timelapse.model";
import { TimelapseService } from "../../services/timelapse.service";
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: "create-story",
  templateUrl: "./create-story.component.html",
  styleUrls: ["./create-story.component.css"]
})
export class CreateStoryComponent implements OnInit {
  user: User = new User();
  submitted: boolean = false;
  hideProfile = false;
  pwdMatched: boolean;
  userCreated: boolean;
  userForm: FormGroup;

  idPlace: number;
  idTimelapse: number;
  idType: number;
  inputTitle: string; 
  inputDescription: string; 
  inputContent: string; 

  nickname: FormControl;
  email: FormControl;
  password: FormControl;
  city: FormControl;
  passwordConfirm: FormControl;
  profile: FormControl;

  types: Type[];
  type: FormControl;
  timelapses: Timelapse[];
  timelapse: FormControl;
  places: Place[];
  place: FormControl;
  title: FormControl;
  description: FormControl;
  content: FormControl;

  currentUser: User;
  temp: string ; 
  passageparmap: boolean = false;
  placeOld: Place = new Place();
  urlStory: string;

  constructor(
    private userService: UserService,
    private typeService: TypeService,
    private timelapseService: TimelapseService,
    private placeService: PlaceService,
    private storyService: StoryService, 
    private router: Router
  ) { }

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];
  selectedValue = this.profiles[0].id;


  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    this.temp = JSON.parse(sessionStorage.getItem("passageparmap") || '{}');
    this.placeOld.longitude = JSON.parse(sessionStorage.getItem("longitude") || '{}');
    this.placeOld.latitude = JSON.parse(sessionStorage.getItem("latitude") || '{}');
    if (this.temp == "passageparmap") {
      this.passageparmap = true;
    } else {
      this.passageparmap = false;
    }
    this.getIdPlaceJustCreated();
    this.getTypes();
    this.getTimelapses();
    this.getPlaces();
    this.controlFormUser();
    this.createFormUser();
    sessionStorage.removeItem("longitude");
    sessionStorage.removeItem("latitude");
    sessionStorage.removeItem("passageparmap");
  }

  createUser() {
    this.userService
      .createUser(this.user)
      .subscribe(data => this.userCreated = true, error => this.userCreated = false);
  }

  createStory(){
    console.log("this.currentUser = " + this.currentUser.id);
    this.storyService
    .createStory(this.idPlace, this.idType, this.idTimelapse, this.currentUser.id, this.inputTitle, this.inputDescription, this.inputContent)
    .subscribe(data => this.userCreated = true, error => this.userCreated = false);
  }
 
  onSubmit() {
    this.submitted = true;
    if (this.userForm.valid) {
      //this.createUser();
      //this.userForm.reset();
    }
    console.log("le type = ", this.idType);
    console.log("le timelapse = ", this.idTimelapse);
    console.log("l adresse = ", this.idPlace);
    this.createStory();
    this.urlStory = "/demo/display-map"
    this.router.navigate([this.urlStory]);
  }

  controlFormUser() {
    this.profile = new FormControl('', [
      Validators.required
    ]);
    this.type = new FormControl('', [
      Validators.required
    ]);
    this.timelapse = new FormControl('', [
      Validators.required
    ]);
    this.place = new FormControl('', [
      Validators.required
    ]);
    this.title = new FormControl('', [
      Validators.required
    ]);
    this.description = new FormControl('', [
      Validators.maxLength(80), 
    ]);
    this.content = new FormControl('', [
      Validators.maxLength(1000), 
    ]);


  }

  createFormUser() {
    this.userForm = new FormGroup({
      profile: this.profile,
      type: this.type,
      timelapse: this.timelapse,
      place: this.place,
      title: this.title,
      description: this.description,
      content: this.content 
    });
  }

  getTypes() {
    this.typeService
      .findAllTypes()
      .subscribe(types => { this.types = types, console.log(this.types) }, err => console.log(err));
  }

  getTimelapses() {
    this.timelapseService
      .findAllTimelapses()
      .subscribe(timelapses => { this.timelapses = timelapses, console.log(this.timelapses) }, err => console.log(err));
  }

  getPlaces() {
    this.placeService
      .findAllPlaces()
      .subscribe(places => { this.places = places, console.log(this.timelapses) }, err => console.log(err));
  }

  getIdPlaceJustCreated() {
    this.placeService.findByCoordinates(this.placeOld.longitude, this.placeOld.latitude)
      .toPromise()
      .then(
        idPlace => {
          this.idPlace = idPlace;
        }
      );
  }
}