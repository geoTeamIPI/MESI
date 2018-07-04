import { Component, HostBinding, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { select, Store } from '@ngrx/store';
import { first, withLatestFrom } from 'rxjs/operators';
import { State } from './app.module';
import * as fromApp from './app.selectors';
import * as demo from './map/demo.actions';
import { LoginComponent } from "./login/login.component"; 
import { AuthenticationService } from "./services/authentication.service";
import { User } from './models/user.model';


@Component({
  selector: 'showcase-root',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.scss']
})
export class IndexComponent implements OnInit{
  @HostBinding('class.mat-typography') class = true;

  isDemoEditing$ = this.store.pipe(select(fromApp.isDemoEditing));
  isInDemo$ = this.store.pipe(select(fromApp.isInDemo));

  private currentRouterState$ = this.store.pipe(select(fromApp.getCurrentRouterState));
  currentUser: User; 
  isAutenthicated: boolean = false; 

  constructor(
    private store: Store<State>,
    private router: Router
  ) { }

  ngOnInit(){
    if (sessionStorage.getItem("currentUser")){
      this.isAutenthicated = true;
      this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));  
    }
  }

  toggleSidenav() {
    this.store.dispatch(new demo.ToggleSidenav());
  }

  toggleEdit() {
    this.isDemoEditing$.pipe(
      first(),
      withLatestFrom(this.currentRouterState$)
    ).subscribe(([isDemoEditing, currentRouterState]) => {
      if (isDemoEditing) {
        this.router.navigate(['demo', currentRouterState.params.demoUrl]);
      } else {
        this.router.navigate(['demo', 'edit', currentRouterState.url.split('/').pop()]);
      }
    });
  }
}
