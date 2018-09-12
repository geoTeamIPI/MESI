import { Component, OnInit } from "@angular/core";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { ActivatedRoute, Router } from "@angular/router";
import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";


@Component({
  selector: "infos-story",
  templateUrl: "./infos-story.component.html",
  styleUrls: ["./infos-story.component.css"]
})
export class InfosStoryComponent implements OnInit {
  story = new Story();
  user = new User();
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(
    private storyService: StoryService,
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    } 
    this.getStory();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
  }

  getStory() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.storyService.getStory(id)
      .subscribe(
        story => {
          this.story = story;
        },
        err => console.log(err)
      );
  }

}
