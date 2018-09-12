import { Component, OnInit } from "@angular/core";
import { TypeService } from "../../services/type.service";
import { Type } from "../../models/type.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { User } from "../../models/user.model";


@Component({
  selector: "infos-type",
  templateUrl: "./infos-type.component.html",
  styleUrls: ["./infos-type.component.css"]
})
export class InfosTypeComponent implements OnInit {
  type = new Type();
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(
    private typeService: TypeService,
    private storyService: StoryService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin"){
      this.isAdmin = true;
    } else{
      this.isAdmin = false;
    } 
    this.getType();
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
  }

  getType() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.typeService.getType(id)
      .subscribe(
        type => {
          this.type = type;
        },
        err => console.log(err)
      );
  }

  reloadData() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.storyService 
      .findAllStoriesByTypeById(id)
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }
}
