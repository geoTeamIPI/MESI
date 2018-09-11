import { Component, OnInit } from "@angular/core";
import { PlaceService } from "../../services/place.service";
import { Place } from "../../models/place.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";


@Component({
  selector: "infos-place",
  templateUrl: "./infos-place.component.html",
  styleUrls: ["./infos-place.component.css"]
})
export class InfosPlaceComponent implements OnInit {
  place = new Place();
  placeIsEmpty = 0;
  storiesIsEmpty = 0;
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};

  constructor(
    private placeService: PlaceService,
    private storyService: StoryService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.getPlace();
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
    console.log("stories is empty = " + this.storiesIsEmpty);
    console.log("places is empty = " + this.IsEmpty);
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
