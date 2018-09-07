 import { Component } from '@angular/core';
 import {  ActivatedRoute } from '@angular/router';

 import { Story } from '../story.model';
 import { StoryLocation } from '../story-location.model';
 import { StoryService } from '../../services/story.service';


 @Component({
   templateUrl: './add-story.component.html'
 })
 export class AddStoryComponent {

   story: Story = new Story();
   storyLocation : StoryLocation = new StoryLocation();

   constructor( private storyService: StoryService, route: ActivatedRoute) {
     route.queryParams.subscribe(params => {
       this.storyLocation.lat = params['lat'];
       this.storyLocation.lng = params['lng'];
      
   });
   
   }

   createStory(): void {
    
     this.story.storyLocation = this.storyLocation;
     console.log(this.story);
     this.storyService.createStory(this.story)
         .subscribe( data => {
           alert("Story created successfully.");
         });

   };

 }