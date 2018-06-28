import {Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Story } from './story.model';


// const httpOptions = {
//   headers: new HttpHeaders({ 'Content-Type': 'application/json' })
// };

@Injectable()
export class StoryService {

  constructor(private http:HttpClient) {}

  //private userUrl = 'http://localhost:8080/user-portal/user';
	private storyUrl = '/api';

  public getStories() {
    return this.http.get<Story[]>(this.storyUrl);
  }

  public deleteStory(story: Story) {
    return this.http.delete(this.storyUrl + "/"+ story.id);
  }

  public createStory( story: Story) {
    return this.http.post<Story>(this.storyUrl, story);
  }

}
