import { Component, OnInit, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { TypeService } from "../../services/type.service";
import { Type } from "../../models/type.model";
import { User } from "../../models/user.model";

@Component({
  selector: "update-type",
  templateUrl: "./update-type.component.html",
  styleUrls: ["./update-type.component.css"]
})
export class UpdateTypeComponent implements OnInit {
  @Input() type: Type;
  typeUpdated : boolean = false; 
  submitted: boolean = false;  
  currentUser: User; 

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];

  constructor(
    private route: ActivatedRoute,
    private typeService: TypeService
  ) {}

  ngOnInit() {
    this.getType();
  }

  getType() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.typeService
      .getType(id)
      .subscribe(type => {this.type = type}, err => console.log(err));
    console.log("ma type vaut = " + this.type);
  }

  onSubmit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    const id = +this.route.snapshot.paramMap.get("id");
    this.typeService
      .updateType(id, this.type, this.currentUser.id )
      .subscribe(data => {this.typeUpdated = true, console.log("Adresse mise à jour")}, err => console.log(err));
      this.submitted = true; 
  }
}
