import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MapMouseEvent } from 'mapbox-gl';
import { Cluster, Supercluster } from 'supercluster';
import { LngLatLike } from 'mapbox-gl';
import { MatPaginator, PageEvent } from '@angular/material';
import { User } from "../../models/user.model";
import { StoryService } from "../../services/story.service";
import { Story } from "../../models/story.model";
import { ActivatedRoute, Router } from "@angular/router";

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'demo-cluster-popup',
  template: "popup-on-click.component.html"
})
export class ClusterPopupComponent implements OnChanges, OnInit {
  @Input() clusterId: GeoJSON.Feature<GeoJSON.Point>;
  @Input() supercluster: Supercluster;
  @Input() count: number;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  leaves: GeoJSON.Feature<GeoJSON.Point>[];

  ngOnChanges(changes: SimpleChanges) {
    this.changePage();
    if (changes.count && !changes.count.isFirstChange()) {
      this.paginator.firstPage();
    }
  }

  changePage(pageEvent?: PageEvent) {
    let offset = 0;
    if (pageEvent) {
      offset = pageEvent.pageIndex * 5;
    }
    // Typing issue in supercluster
    this.leaves = (<any>this.supercluster.getLeaves)(this.clusterId, 5, offset);
  }
}



@Component({
  selector: 'showcase-demo',
  templateUrl: "popup-on-click.component.html",
  styleUrls: ['./examples.css', './set-style.component.css']
})
export class PopupOnClickComponent implements OnInit {
  //stories: any =[];
  earthquakes: object;
  address: string;
  currentUser: User;
  isAdmin: string = "notConnected";
  idSelectedStory: number; 
  stories: Story[];
  icontime: string;
  selectedPoint: GeoJSON.Feature<GeoJSON.Point> | null;
  supercluster: Supercluster;
  selectedCluster: {
    lngLat: LngLatLike;
    count: number;
    id: number;
  };

  constructor(private storyService: StoryService, private route: ActivatedRoute, private router: Router) { }

  async ngOnInit() {
    this.earthquakes = await import('./earthquakes.geo.json');
    console.log("this earthquakes = " + this.earthquakes);
    //https://codepen.io/parry-drew/pen/wWYXmR
    //this.storyService
    //.findAllStories()
    //.subscribe(stories => { this.stories = stories }, err => console.log(err));
    //console.log("this earthquakes = " + this.earthquakes);
    this.getStories();
    console.log(this.stories);
  }


  onClick(evt: MapMouseEvent) {
    this.selectedPoint = (<any>evt).features[0];
    this.idSelectedStory = (<any>evt).features[0].properties.id;
    this.icontime = (<any>evt).features[0].properties.type.substr((<any>evt).features[0].properties.type.indexOf('pathpicture')+14);
    this.icontime = this.icontime.substr(0, this.icontime.length - 2);
    this.icontime = "../../../assets/" + this.icontime;
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = "admin";
      this.address = "/account/admin/stories/infos/" + this.idSelectedStory;
    } else if (this.currentUser.profile == "user"){
      this.isAdmin = "user";
      this.address = "/account/user/stories/infos/" + this.idSelectedStory;
    } else {
      this.address = "/noaccount/display/stories/infos/" + this.idSelectedStory;
    } 
  }

  getStories() { 
    this.storyService
      .findAllStories()
      .subscribe(stories => { this.stories = stories }, err => console.log(err));
    this.router.navigate([this.router.url]);
  }
}
