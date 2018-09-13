import { Component, OnInit } from "@angular/core";

import { User } from "../../models/user.model";
import { Timelapse } from "../../models/timelapse.model";
import { Type } from "../../models/type.model";
import { Story } from "../../models/story.model";
import { Place } from "../../models/place.model";
import { StoryService } from "../../services/story.service";
import { UserService } from "../../services/user.service";
import { PlaceService } from "../../services/place.service";
import { TimelapseService } from "../../services/timelapse.service";
import { TypeService } from "../../services/type.service";
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from "@angular/router";

@Component({
  selector: "create-story",
  templateUrl: "./create-story.component.html",
  styleUrls: ["./create-story.component.css"]
})
export class CreateStoryComponent implements OnInit {
  users: User[];
  places: Place[];
  timelapses: Timelapse[];
  types: Type[];
  story: Story = new Story();

  stories: Story[];
  storyForm: FormGroup;
  submitted: boolean = false;
  hideProfile = false;
  storyCreated: boolean;
  
  place: FormControl; 
  timelapse : FormControl; 
  type: FormControl; 
  creator: FormControl;
  title: FormControl;
  

  /* title: FormControl;
   creator: User;
   place: Place;
   type: Type;
   timelapse: Timelapse;*/

  currentUser: User;

  constructor(
    private storyService: StoryService,
    private router: Router,
    private placeService: PlaceService,
    private timelapseService: TimelapseService,
    private typeService: TypeService,
    private userService: UserService) { }

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];
  selectedValue = this.profiles[0].id;


  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    //this.controlFormStory();
    this.getUsers();
    this.getPlaces();
    this.getTypes();
    this.getTimelapses();
    this.createFormStory();
  }

  createStory() {
    this.storyService
      .createStory(this.story,  this.currentUser.id)
      .subscribe(data => {console.log(data), this.storyCreated = true}, error => this.storyCreated = false);
  }

  onSubmit() {
    //this.submitted = true;
    //if (this.storyForm.valid) {
    this.createStory();
    //this.storyForm.reset();
    //}
    console.log("Mon créateur vaut" + this.story.creator);
    console.log("Ma période vaut" + this.story.timelapse);
    console.log("Mon type vaut" + this.story.type);
    console.log("Ma place vaut" + this.story.place);
  }

  /* controlFormStory() {
     this.title = new FormControl('', [
       Validators.required
     ]);*/
  /*this.email = new FormControl('', [
    Validators.email,
    Validators.minLength(7),
    Validators.required]);
  this.password = new FormControl('', [
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
  ]);*/
  /*this.creator = new FormControl('', [
    Validators.required
  ]);
  this.place = new FormControl('', [
    Validators.required
  ]);
  this.type = new FormControl('', [
    Validators.required
  ]);
  this.timelapse = new FormControl('', [
    Validators.required
  ]);
}*/

  /*createFormStory() {
    this.storyForm = new FormGroup({
      profile: this.profile,,
      title: this.title,
      creator: this.creator,
      place: this.place,
      type: this.type,
      timelapse: this.timelapse;
    });
  }*/

  getUsers() {
    this.userService
      .findAllUsers()
      .subscribe(users => { this.users = users, console.log(this.users) }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }

  getPlaces() {
    this.placeService
      .findAllPlaces()
      .subscribe(places => { this.places = places, console.log(this.places) }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }

  getTypes() {
    this.typeService
      .findAllTypes()
      .subscribe(types => { this.types = types, console.log(this.types) }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }

  getTimelapses() {
    this.timelapseService
      .findAllTimelapses()
      .subscribe(timelapses => { this.timelapses = timelapses, console.log(this.timelapses) }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }

  createFormStory(){
    this.storyForm  = new FormGroup({
      title: this.title, 
      creator: this.creator, 
      place: this.place, 
      timelapse: this.timelapse, 
      type: this.type, 
    });
  }
}