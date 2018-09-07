import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';

import {Story} from "../models/story.model";


@Injectable()
export class StoryService {

  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8080"; 
  private storiesUrl = this.baseUrl + "/stories";

  // ----------------------------------------------- GET STORIES METHODS ---------------

  public findAllStories(){
    return this.http.get<Story[]>(this.storiesUrl); 
  }

  public findAllStoriesOfUser(idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/user", { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public findAllStoriesByScreen(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/screen" 
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    );
  }

  public findAllStoriesByScreenOfUser(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/user/screen"     
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    , { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public findAllStoriesByDiameter(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    longitudeUser: String, 
    latitudeUser: String,
    diameter: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/diameter" 
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    + "&" + "longitudeUser=" + longitudeUser
    + "&" + "latitudeUser=" + latitudeUser
    + "&" + "diameter=" + diameter
    );
  }

  public findAllStoriesByDiameterOfUser(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    longitudeUser: String, 
    latitudeUser: String,
    diameter: number, 
    idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/user/diameter" 
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    + "&" + "longitudeUser=" + longitudeUser
    + "&" + "latitudeUser=" + latitudeUser
    + "&" + "diameter=" + diameter
    , { 
      headers: {"idUser": idUser.toString()}
    });
  }

// ----------------------------------------------- COUNT STORIES METHODS ---------------

  public countAllStories(){
    return this.http.get<Story[]>(this.storiesUrl + "/count"); 
  }

  public countAllStoriesOfUser(idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/count/user", { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public countAllStoriesByScreen(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/count/screen"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    ); 
  }

  public countAllStoriesByScreenOfUser(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/count/user/screen"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public countAllStoriesByDiameter(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    longitudeUser: String, 
    latitudeUser: String,
    diameter: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/count/diameter"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    + "&" + "longitudeUser=" + longitudeUser
    + "&" + "latitudeUser=" + latitudeUser
    + "&" + "diameter=" + diameter
    ); 
  }

  public countAllStoriesByDiameterOfUser(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    longitudeUser: String, 
    latitudeUser: String,
    diameter: number, 
    idUser: number): Observable<any>{
    return this.http.get<Story[]>(this.storiesUrl + "/count/diameter"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    + "&" + "longitudeUser=" + longitudeUser
    + "&" + "latitudeUser=" + latitudeUser
    + "&" + "diameter=" + diameter, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  // ----------------------------------------------- CRUD METHODS ---------------

  public createStory(story: Story) {
    return this.http.post<Story>(this.storiesUrl + "/add", story);
  }

  public getStory(id: number): Observable<any>{
    return this.http.get(this.storiesUrl + "/display/" + id);
  }

  public updateStory(id: number, value: any): Observable<any> {
    return this.http.post<Story>(this.storiesUrl + "/update/" + id, value);
  }

  public deleteStory(id: number) {
    return this.http.delete(this.storiesUrl + "/delete/" + id);
  }
}
