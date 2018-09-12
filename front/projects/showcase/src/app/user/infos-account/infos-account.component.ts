import { Component, OnInit } from "@angular/core";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";

@Component({
  selector: 'infos-account',
  templateUrl: './infos-account.component.html',
  styleUrls: ['./infos-account.component.css']
})
export class InfosAccountComponent implements OnInit {
  userInfos: User;
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
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
    if (this.currentUser.profile == "admin") {
      this.isAdmin = true;
    } else {
      this.isAdmin = false;
    }
    this.userService.getAccount(this.currentUser.id)
      .subscribe(user => {
        this.userInfos = user;
      });
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
  }

  reloadData() {
    this.storyService
      .findAllStoriesByCreatorById(this.currentUser.id)
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }

}
