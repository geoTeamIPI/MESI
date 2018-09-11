import { Component, OnInit, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { TimelapseService } from "../../services/timelapse.service";
import { Timelapse } from "../../models/timelapse.model";
import { User } from "../../models/user.model";

@Component({
  selector: "update-timelapse",
  templateUrl: "./update-timelapse.component.html",
  styleUrls: ["./update-timelapse.component.css"]
})
export class UpdateTimelapseComponent implements OnInit {
  @Input() timelapse: Timelapse;
  timelapseUpdated : boolean = false; 
  submitted: boolean = false;  
  currentUser: User; 

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];

  constructor(
    private route: ActivatedRoute,
    private timelapseService: TimelapseService
  ) {}

  ngOnInit() {
    this.getTimelapse();
  }

  getTimelapse() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.timelapseService
      .getTimelapse(id)
      .subscribe(timelapse => {this.timelapse = timelapse}, err => console.log(err));
  }

  onSubmit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    const id = +this.route.snapshot.paramMap.get("id");
    this.timelapseService
      .updateTimelapse(id, this.timelapse, this.currentUser.id )
      .subscribe(data => {this.timelapseUpdated = true, console.log("Adresse mise à jour")}, err => console.log(err));
      this.submitted = true; 
  }
}
