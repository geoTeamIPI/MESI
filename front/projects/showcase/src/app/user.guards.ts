import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from './models/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserGuards implements CanActivate { 
  currentUser: User; 

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}'); 
      if (this.currentUser != null && this.currentUser.profile == "user"){
        return true; 
      }
      alert("Vous devez être identifié comme utilisateur"); 
    return false;
  }
}
