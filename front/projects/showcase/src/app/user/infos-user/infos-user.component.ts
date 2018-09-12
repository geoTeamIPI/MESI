import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";

@Component({
  selector: "infos-user",
  templateUrl: "./infos-user.component.html",
  styleUrls: ["./infos-user.component.css"]
})
export class InfosUserComponent implements OnInit {
  user = new User();
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false;
  currentUser: User;

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private storyService: StoryService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getUser();
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
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

  reloadData() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.storyService
      .findAllStoriesByCreatorById(id)
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }
}
