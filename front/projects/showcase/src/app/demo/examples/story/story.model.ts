import { StoryLocation } from "./story-location.model";

export class Story {

    id: string;
    title: string;
    description: string;
    content: string;
    date: {
        year: number,
        month: number,
        day: number
      };
    storyLocation: StoryLocation;
  }
