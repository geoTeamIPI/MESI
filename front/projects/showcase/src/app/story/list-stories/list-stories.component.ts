import { Component, OnInit } from "@angular/core";

import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { ActivatedRoute, Router } from "@angular/router";
import { User } from "../../models/user.model";

@Component({
  selector: "list-stories",
  templateUrl: "./list-stories.component.html",
  styleUrls: ["./list-stories.component.css"]
})

export class ListStoriesComponent implements OnInit {
  stories: Story[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(private storyService: StoryService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    }
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
  }

  deleteStory(id: number, index : number) {
    if (confirm("Etes-vous sûr de vouloir supprimer cette histoire ?") == true) {
      this.storyService
        .deleteStory(id, this.currentUser.id)
        .subscribe(data => console.log(), err => console.log(err));
        this.stories.splice(index, 1);
    }
  }

  reloadData() {
        this.storyService
      .findAllStories()
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
