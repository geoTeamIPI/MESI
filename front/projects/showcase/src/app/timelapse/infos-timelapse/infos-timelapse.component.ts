import { Component, OnInit } from "@angular/core";
import { TimelapseService } from "../../services/timelapse.service";
import { Timelapse } from "../../models/timelapse.model";
import { ActivatedRoute, Router } from "@angular/router";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { User } from "../../models/user.model";


@Component({
  selector: "infos-timelapse",
  templateUrl: "./infos-timelapse.component.html",
  styleUrls: ["./infos-timelapse.component.css"]
})
export class InfosTimelapseComponent implements OnInit {
  timelapse = new Timelapse();
  stories: Story[];
  size: number;
  sortProperty: string;
  sortDirection: string;
  pagination: any = {};
  isAdmin: boolean = false; 
  currentUser : User; 

  constructor(
    private timelapseService: TimelapseService,
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
    this.getTimelapse();
    this.reloadData();
    this.route.queryParams.subscribe(values => {
      this.pagination = values;
      console.log(this.pagination);
    });
  }

  getTimelapse() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.timelapseService.getTimelapse(id)
      .subscribe(
        timelapse => {
          this.timelapse = timelapse;
        },
        err => console.log(err)
      );
  }

  reloadData() {
    const id = +this.route.snapshot.paramMap.get("id");
    this.storyService 
      .findAllStoriesByTimelapseById(id)
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }
}
