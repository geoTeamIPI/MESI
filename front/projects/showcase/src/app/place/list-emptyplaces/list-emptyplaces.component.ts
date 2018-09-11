import { Component, OnInit } from "@angular/core";

import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "../../models/user.model";

@Component({
  selector: "list-emptyplaces",
  templateUrl: "./list-emptyplaces.component.html",
  styleUrls: ["./list-emptyplaces.component.css"]
})

export class ListEmptyPlacesComponent implements OnInit {
  places: Place[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  currentUser: User; 
  isAdmin: boolean; 

  constructor(private placeService: PlaceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    }
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
  }

  deletePlace(id: number, index : number) {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (confirm("Etes-vous sûr de vouloir supprimer cette adresse") == true) {
      this.placeService
        .deletePlace(id, this.currentUser.id)
        .subscribe(data => console.log(), err => console.log(err));
      this.places.splice(index, 1);
    }
  }

  reloadData() {
        this.placeService
      .findAllEmptyPlaces()
      .subscribe(places => { this.places = places }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }

}
