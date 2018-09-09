import { Story } from "../models/story.model";

export class StoryLocation {

     id: string;
     lat: string;
     lng: string;
     address: string;
     stories: Story[];
}