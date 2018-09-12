import { Component, OnInit } from "@angular/core";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { ActivatedRoute } from "@angular/router";
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
  isAdmin: string = "notConnected"; 
  currentUser : User; 

  constructor(
    private storyService: StoryService,
    private route: ActivatedRoute,
  ) { }

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = "admin";
    } else if (this.currentUser.profile == "user") {
      this.isAdmin = "user";
    } else{
      this.isAdmin = "notConnected";
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
