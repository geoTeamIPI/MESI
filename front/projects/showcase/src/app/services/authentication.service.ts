import { Injectable } from '@angular/core';

import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService{

  constructor(private http: HttpClient) {  
  }

  private userUrl = 'http://localhost:8080/user';

  login(email: string, password: string): Observable<any>{
    return this.http.post<any>(this.userUrl + "/login", {email: email, password: password})
    .pipe(map(user => {
        sessionStorage.setItem('currentUser', JSON.stringify(user));
    }));
  }
  
  logout(){
    sessionStorage.removeItem('currentUser'); 
  }


}
