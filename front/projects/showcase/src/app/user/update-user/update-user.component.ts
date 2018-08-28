import { Component, OnInit, Input } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";

@Component({
  selector: "app-update-user",
  templateUrl: "./update-user.component.html",
  styleUrls: ["./update-user.component.css"]
})
export class UpdateUserComponent implements OnInit {
  @Input() user: User;
  userUpdated : boolean = false; 
  submitted: boolean = false;  

  profiles = [
    { id: "user", name: "Utilisateur" },
    { id: "moderator", name: "Modérateur" },
    { id: "admin", name: "Administrateur" }
  ];

  constructor(
    private route: ActivatedRoute,
    private userService: UserService
  ) {}

  ngOnInit() {
    this.getUser();
  }

  getUser() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.userService
      .getUser(id)
      .subscribe(user => {this.user = user}, err => console.log(err));
  }

  onSubmit() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.userService
      .updateUser(id, this.user)
      .subscribe(data => {this.userUpdated = true, console.log("User updated")}, err => console.log(err));
      this.submitted = true; 
  }
}
