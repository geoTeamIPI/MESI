import { Component, OnInit } from "@angular/core";

import { UserService } from "../../services/user.service";
import { User } from "../../models/user.model";
import { ActivatedRoute } from "@angular/router";

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


  constructor(private userService: UserService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values; 
      console.log(this.pagination); 
    })
  }

  deleteUser(id: number) {
    if (confirm("Etes-vous sûr de vouloir supprimer cet utilisateur") == true) {
      this.userService
        .deleteUser(id)
        .subscribe(data => console.log(), err => console.log(err));
      this.reloadData();
    }
  }

  reloadData() {
        this.userService
      //.findAllUsers(this.pagination.page, this.pagination.size, this.pagination.sortProperty, this.pagination.sortDirection)
      .findAllUsers()
      .subscribe(users => { this.users = users }, err => console.log(err));
  }
}
