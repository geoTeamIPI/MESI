import { Component, OnInit } from "@angular/core";

import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "../../models/user.model";

@Component({
  selector: "list-myplaces",
  templateUrl: "./list-myplaces.component.html",
  styleUrls: ["./list-myplaces.component.css"]
})

export class ListMyPlacesComponent implements OnInit {
  places: Place[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  currentUser: User; 


  constructor(private placeService: PlaceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
  }

  deletePlace(id: number, index : number) {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (confirm("Etes-vous sûr de vouloir supprimer cette adresse ?") == true) {
      this.placeService
        .deletePlace(id, this.currentUser.id)
        .subscribe(data => console.log(), err => console.log(err));
      this.places.splice(index, 1);
    }
  }

  reloadData() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
        this.placeService
      .findAllPlacesOfUser(this.currentUser.id)
      .subscribe(places => { this.places = places }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
