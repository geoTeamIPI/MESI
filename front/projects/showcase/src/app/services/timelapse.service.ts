import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';

import {Timelapse} from "../models/timelapse.model";


@Injectable()
export class TimelapseService {

  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8080"; 
  private timelapsesUrl = this.baseUrl + "/timelapses";

  // ----------------------------------------------- GET PLACES METHODS ---------------

  public findAllTimelapses(){
    return this.http.get<Timelapse[]>(this.timelapsesUrl); 
  }

  public findAllTimelapsesApprove(){ 
    return this.http.get<Timelapse[]>(this.timelapsesUrl + "/approve"); 
  }

// ----------------------------------------------- COUNT PLACES METHODS ---------------

  public countAllTimelapses(){
    return this.http.get<Timelapse[]>(this.timelapsesUrl + "/count"); 
  }


  // ----------------------------------------------- CRUD METHODS ---------------

  public createTimelapse(timelapse: Timelapse, idUser: number) {
    return this.http.post<Timelapse>(this.timelapsesUrl + "/add", timelapse, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public getTimelapse(id: number): Observable<any>{
    return this.http.get(this.timelapsesUrl + "/display/" + id);
  }

  public updateTimelapse(id: number, value: any, idUser: number): Observable<any> {
    return this.http.post<Timelapse>(this.timelapsesUrl + "/update/" + id, value, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public deleteTimelapse(id: number, idUser: number) {
    return this.http.delete(this.timelapsesUrl + "/delete/" + id, { 
      headers: {"idUser": idUser.toString()}
    });
  }
} 
