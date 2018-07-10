import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-infos-account',
  templateUrl: './infos-account.component.html',
  styleUrls: ['./infos-account.component.css']
})
export class InfosAccountComponent implements OnInit {

  currentUser: User;
  userInfos: User; 


  constructor(private userService: UserService) { }

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser"));
    this.userService.getAccount(this.currentUser.id)
      .subscribe(user => {
        this.userInfos = user; 
      });
  }

}
