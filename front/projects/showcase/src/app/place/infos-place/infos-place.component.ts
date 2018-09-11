import { Component, OnInit } from "@angular/core";
import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { User } from "../../models/user.model";


@Component({
  selector: "infos-place",
  templateUrl: "./infos-place.component.html",
  styleUrls: ["./infos-place.component.css"]
})
export class InfosPlaceComponent implements OnInit {
  place = new Place();
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(
    private placeService: PlaceService,
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
    this.getPlace();
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
  }

  getPlace() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.placeService.getPlace(id)
      .subscribe(
        place => {
          this.place = place;
        },
        err => console.log(err)
      );
  }

  reloadData() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.storyService
      .findAllStoriesByPlaceById(id)
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }
}
