import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';

import {Type} from "../models/type.model";


@Injectable()
export class TypeService {

  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8080"; 
  private typesUrl = this.baseUrl + "/types";

  // ----------------------------------------------- GET PLACES METHODS ---------------

  public findAllTypes(){
    return this.http.get<Type[]>(this.typesUrl); 
  }

  public findAllTypesApprove(){ 
    return this.http.get<Type[]>(this.typesUrl + "/approve"); 
  }

// ----------------------------------------------- COUNT PLACES METHODS ---------------

  public countAllTypes(){
    return this.http.get<Type[]>(this.typesUrl + "/count"); 
  }


  // ----------------------------------------------- CRUD METHODS ---------------

  public createType(type: Type, idUser: number) {
    return this.http.post<Type>(this.typesUrl + "/add", type, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public getType(id: number): Observable<any>{
    return this.http.get(this.typesUrl + "/display/" + id);
  }

  public updateType(id: number, value: any, idUser: number): Observable<any> {
    return this.http.post<Type>(this.typesUrl + "/update/" + id, value, { 
      headers: {"idUser": idUser.toString()}
    });
  }

  public deleteType(id: number, idUser: number) {
    return this.http.delete(this.typesUrl + "/delete/" + id, { 
      headers: {"idUser": idUser.toString()}
    });
  }
} 
