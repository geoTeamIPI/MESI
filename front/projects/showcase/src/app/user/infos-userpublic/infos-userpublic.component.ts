import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: "infos-userpublic",
  templateUrl: "./infos-userpublic.component.html",
  styleUrls: ["./infos-userpublic.component.css"]
})
export class InfosUserPublicComponent implements OnInit {
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
