 import { Component, OnInit } from '@angular/core';

 import { Story } from '../models/story.model';
 import { StoryService } from '../services/story.service';

 @Component({
   selector: 'app-story',
   templateUrl: './story.component.html',
   styleUrls: ["./story.component.css"]
 })
 export class StoryComponent implements OnInit {

   stories: Story[];

   constructor( private storyService: StoryService) {

   }

   ngOnInit() {
     this.storyService.findAllStories()
       .subscribe( data => {
         this.stories = data;
       });
   };

   deletestory(story: Story): void {
     this.storyService.deleteStory(story
       .subscribe( data => {
         this.stories = this.stories.filter(u => u !== story);
       })
   };

 } 