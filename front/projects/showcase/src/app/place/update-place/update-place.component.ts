import { Component, OnInit, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { User } from "../../models/user.model";

@Component({
  selector: "update-place",
  templateUrl: "./update-place.component.html",
  styleUrls: ["./update-place.component.css"]
})
export class UpdatePlaceComponent implements OnInit {
  @Input() place: Place;
  placeUpdated : boolean = false; 
  submitted: boolean = false;  
  currentUser: User; 

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];

  constructor(
    private route: ActivatedRoute,
    private placeService: PlaceService
  ) {}

  ngOnInit() {
    this.getPlace();
  }

  getPlace() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.placeService
      .getPlace(id)
      .subscribe(place => {this.place = place}, err => console.log(err));
  }

  onSubmit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    const id = +this.route.snapshot.paramMap.get("id");
    this.placeService
      .updatePlace(id, this.place, this.currentUser.id )
      .subscribe(data => {this.placeUpdated = true, console.log("Adresse mise à jour")}, err => console.log(err));
      this.submitted = true; 
  }
}
