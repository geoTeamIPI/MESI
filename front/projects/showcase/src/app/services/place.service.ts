import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';

import {Place} from "../models/place.model";


@Injectable()
export class PlaceService {

  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8080"; 
  private placesUrl = this.baseUrl + "/places";

  // ----------------------------------------------- GET PLACES METHODS ---------------

  public findAllPlaces(){
    return this.http.get<Place[]>(this.placesUrl); 
  }

  public findAllPlacesOfUser(idUser: number): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/user", { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public findAllPlacesByScreen(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/screen" 
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    );
  }

  
  public findAllPlacesByScreenOfUser(
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    idUser: number): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/user/screen"     
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    , { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public findAllEmptyPlaces(){
    return this.http.get<Place[]>(this.placesUrl + "/compare"); 
  }

  public findByCoordinates(
    longitude: String, 
    latitude: String
  ): Observable<any>{
    return this.http.get<number[]>(this.placesUrl + "/coordinates"     
    + "?" + "longitude=" + longitude 
    + "&" + "latitude=" + latitude
    );
  }

// ----------------------------------------------- COUNT PLACES METHODS ---------------

  public countAllPlaces(){
    return this.http.get<Place[]>(this.placesUrl + "/count"); 
  }

  public countAllPlacesOfUser(idUser: number): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/count/user", { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public countAllPlacesByScreen(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/count/screen"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE
    ); 
  }

  public countAllPlacesByScreenOfUser(    
    longitudeSW: String, 
    latitudeSW: String, 
    longitudeNE: String, 
    latitudeNE: String, 
    idUser: number): Observable<any>{
    return this.http.get<Place[]>(this.placesUrl + "/count/user/screen"
    + "?" + "longitudeSW=" + longitudeSW 
    + "&" + "latitudeSW=" + latitudeSW 
    + "&" + "longitudeNE=" + longitudeNE 
    + "&" + "latitudeNE=" + latitudeNE, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  // ----------------------------------------------- CRUD METHODS ---------------

  public createPlace(place: Place, idUser: number) {
    return this.http.post<Place>(this.placesUrl + "/add", place, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public createPlaceByCoordinates(longitude: string, latitude: string, idUser: number) {
    return this.http.post<Place>(this.placesUrl + "/add/coordinates" + "?" + "longitude=" + longitude 
    + "&" + "latitude=" + latitude , { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public getPlace(id: number): Observable<any>{
    return this.http.get(this.placesUrl + "/display/" + id);
  }

  public updatePlace(id: number, value: any, idUser: number): Observable<any> {
    return this.http.post<Place>(this.placesUrl + "/update/" + id, value, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public deletePlace(id: number, idUser: number) {
    return this.http.delete(this.placesUrl + "/delete/" + id, { 
      headers: {"idUser": idUser.toString()}
    });
  }
} 
