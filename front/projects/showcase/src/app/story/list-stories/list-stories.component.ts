import { Component, OnInit } from "@angular/core";

import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { ActivatedRoute, Router } from "@angular/router";

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


  constructor(private storyService: StoryService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
    console.log(this.stories);
  }


  deleteStory(id: number) {
    if (confirm("Etes-vous sûr de vouloir supprimer cette story") == true) {
      this.storyService
        .deleteStory(id)
        .subscribe(data => console.log(), err => console.log(err));
    }
    this.reloadData(); 
  }

  reloadData() {
        this.storyService
      .findAllStories()
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
