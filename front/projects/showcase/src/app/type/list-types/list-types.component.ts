import { Component, OnInit } from "@angular/core";

import { TypeService } from "../../services/type.service";
import { Type } from "../../models/type.model";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "../../models/user.model";

@Component({
  selector: "list-types",
  templateUrl: "./list-types.component.html",
  styleUrls: ["./list-types.component.css"]
})

export class ListTypesComponent implements OnInit {
  types: Type[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(private typeService: TypeService, private route: ActivatedRoute, private router: Router) {}

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

  deleteType(id: number, index : number) {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (confirm("Etes-vous sûr de vouloir supprimer cette adresse") == true) {
      this.typeService
        .deleteType(id, this.currentUser.id)
        .subscribe(data => console.log(), err => console.log(err));
        this.types.splice(index, 1);
    }
  }

  reloadData() {
        this.typeService
      .findAllTypes()
      .subscribe(types => { this.types = types }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
