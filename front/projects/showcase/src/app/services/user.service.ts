import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import {Observable} from 'rxjs';

import { User } from "../models/user.model";


@Injectable()
export class UserService {

  currentUser: User = JSON.parse(sessionStorage.getItem("currentUser"));

  constructor(private http: HttpClient) {}

  private baseUrl = "http://localhost:8080"; 
  private usersUrl = this.baseUrl + "/users";
  private userUrl = this.baseUrl+"/user"; 

  public findAllUsers(){
    return this.http.get<User[]>(this.usersUrl); 
  }

  public getUser(id: number): Observable<any> {
    return this.http.get(this.usersUrl + "/infos/" + id);
  }

  public createUser(user: User) {
    return this.http.post<User>(this.usersUrl + "/add", user);
  }

  public updateUser(id: number, value: any): Observable<any> {
    return this.http.post<User>(this.usersUrl + "/update/" + id, value);
  }

  public deleteUser(id: number) {
    return this.http.delete(this.usersUrl + "/" + id);
  }

  public getAccount(id: number): Observable<any>{
    return this.http.get(this.userUrl + "/infos", { 
          headers: {"sid": this.currentUser.id.toString()}
    });
  }

  public updateAccount(id: number, user: User): Observable<any> {
    return this.http.post(this.userUrl + "/update", user, 
      {
        headers: {"sid": this.currentUser.id.toString()}
      }); 
  }

  public registeringAccount(user: User){
      return this.http.post<User>(this.usersUrl + "/registering", user);
  }
}
