import { Component, OnInit } from "@angular/core";

import { TimelapseService } from "../../services/timelapse.service";
import { Timelapse } from "../../models/timelapse.model";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "../../models/user.model";

@Component({
  selector: "list-timelapses",
  templateUrl: "./list-timelapses.component.html",
  styleUrls: ["./list-timelapses.component.css"]
})

export class ListTimelapsesComponent implements OnInit {
  timelapses: Timelapse[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(private timelapseService: TimelapseService, private route: ActivatedRoute, private router: Router) {}

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

  deleteTimelapse(id: number, index : number) {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (confirm("Etes-vous sûr de vouloir supprimer cette adresse") == true) {
      this.timelapseService
        .deleteTimelapse(id, this.currentUser.id)
        .subscribe(data => console.log(), err => console.log(err));
        this.timelapses.splice(index, 1);
    }
  }

  reloadData() {
        this.timelapseService
      .findAllTimelapses()
      .subscribe(timelapses => { this.timelapses = timelapses }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
