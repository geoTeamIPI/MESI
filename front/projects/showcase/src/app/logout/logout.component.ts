import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authenticateService: AuthenticationService, private router: Router) { }

  ngOnInit() {
    this.logout();
    this.router.navigate(["/"]);
    location.reload();
  }

  logout(){
    this.authenticateService.logout();
  }

}
