import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "infos-users",
  templateUrl: "./infos-users.component.html",
  styleUrls: ["./infos-users.component.css"]
})
export class InfosUsersComponent implements OnInit {
  user = new User(); 

  constructor(
    private userService: UserService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.getUser();
  }
  getUser() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.userService.getUser(id)
    .subscribe(
      user => {
        this.user = user;
      },
      err => console.log(err)
    );
  }
}
