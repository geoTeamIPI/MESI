 import { Component } from '@angular/core';
 import {  ActivatedRoute } from '@angular/router';

 import { Story } from '../../models/story.model';
 import { StoryLocation } from '../../models/story-location.model';
 import { StoryService } from '../../services/story.service';

@Component({
  templateUrl: './add-story.component.html'
})
export class AddStoryComponent {

  submitted : boolean;
  storyCreated: boolean; 
  story: Story = new Story();
  storyLocation: StoryLocation = new StoryLocation(); 

  constructor( private storyService: StoryService, route: ActivatedRoute) {}

  onSubmit(){
    this.createStory(); 
    this.submitted = true;
  }

  createStory(): void {
    console.log(this.story);
    this.storyService.createStory(this.story)
        .subscribe( data => {
          this.storyCreated = true; 
          console.log("Création de l'histoire");
        }, error => {
          this.storyCreated = false; 
          console.log("error"); 
        });
   };

 }
