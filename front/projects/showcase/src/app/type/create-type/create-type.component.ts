import { Component, OnInit } from "@angular/core";

import { Type } from "../../models/type.model";
import { User } from "../../models/user.model";
import { TypeService } from "../../services/type.service";

@Component({
  selector: "create-type",
  templateUrl: "./create-type.component.html",
  styleUrls: ["./create-type.component.css"]
})
export class CreateTypeComponent implements OnInit {
  type: Type = new Type();
  submitted: boolean = false;
  typeCreated: boolean;  
  currentUser: User; 
  isAdmin: boolean = false; 
  

  constructor(private typeService: TypeService) {}

  ngOnInit() {
  }

  createType() {
    this.typeService
      .createType(this.type, this.currentUser.id)
      .subscribe(data => this.typeCreated = true, error => this.typeCreated = false);
    this.type = new Type();
  }

  onSubmit() {
    this.createType();
    this.submitted = true; 
  }

}