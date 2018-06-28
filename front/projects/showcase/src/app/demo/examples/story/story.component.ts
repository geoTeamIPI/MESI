import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Story } from './story.model';
import { StoryService } from './story.service';

@Component({
  selector: 'app-story',
  templateUrl: './story.component.html',
  styleUrls: ["./story.component.css"]
})
export class StoryComponent implements OnInit {

  stories: Story[];

  constructor(private router: Router, private storyService: StoryService) {

  }

  ngOnInit() {
    this.storyService.getStories()
      .subscribe( data => {
        this.stories = data;
      });
  };

  deletestory(story: Story): void {
    this.storyService.deleteStory(story)
      .subscribe( data => {
        this.stories = this.stories.filter(u => u !== story);
      })
  };

}