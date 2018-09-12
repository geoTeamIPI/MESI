import { Component, OnInit } from "@angular/core";

import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  selector: "list-users",
  templateUrl: "./list-users.component.html",
  styleUrls: ["./list-users.component.css"]
})

export class ListUsersComponent implements OnInit {
  users: User[];
  size: number;
  sortProperty: string; 
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User;


  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    }
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    });
  }

  deleteUser(id: number, index : number) {
    if (confirm("Etes-vous sûr de vouloir supprimer cet utilisateur ?") == true) {
      this.userService
        .deleteUser(id)
        .subscribe(data => console.log(), err => console.log(err));
        this.users.splice(index, 1);
    }
  }

  reloadData() {
        this.userService
      .findAllUsers()
      .subscribe(users => { this.users = users, console.log(this.users)}, err => console.log(err));
      this.router.navigate([this.router.url]);
  }
}
