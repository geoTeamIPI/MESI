import { Component } from '@angular/core';
import {  ActivatedRoute } from '@angular/router';

import { Story } from '../story.model';
import { StoryLocation } from '../story-location.model';
import { StoryService } from '../story.service';

@Component({
  templateUrl: './add-story.component.html'
})
export class AddStoryComponent {

  submitted : boolean; 
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
          console.log("Création de l'histoire");
        }, error => {
        });

  };

}