import { Component, OnInit } from "@angular/core";

import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "list-places",
  templateUrl: "./list-places.component.html",
  styleUrls: ["./list-places.component.css"]
})

export class ListPlacesComponent implements OnInit {
  places: Place[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};


  constructor(private placeService: PlaceService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
  }

  deletePlace(id: number) {
    const idUser = +this.route.snapshot.paramMap.get("id");
    if (confirm("Etes-vous sûr de vouloir supprimer cette adresse") == true) {
      this.placeService
        .deletePlace(id, idUser)
        .subscribe(data => console.log(), err => console.log(err));
    }
    this.reloadData();
  }

  reloadData() {
        this.placeService
      .findAllPlaces()
      .subscribe(places => { this.places = places }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
