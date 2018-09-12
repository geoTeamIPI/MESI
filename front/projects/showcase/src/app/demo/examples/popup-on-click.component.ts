import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MapMouseEvent } from 'mapbox-gl';
import { Cluster, Supercluster } from 'supercluster';
import { LngLatLike } from 'mapbox-gl';
import { MatPaginator, PageEvent } from '@angular/material';
import { User } from "../../models/user.model";

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'demo-cluster-popup',
  template: `
      <mat-list>
        <mat-list-item
          *ngFor="let leaf of leaves"
        >
          {{ leaf.properties['Secondary ID'] }}
        </mat-list-item>
      </mat-list>
      <mat-paginator
        [length]="count"
        [pageSize]="5"
        (page)="changePage($event)"
      ></mat-paginator>
    `
})
export class ClusterPopupComponent implements OnChanges {
  @Input() clusterId: GeoJSON.Feature<GeoJSON.Point>;
  @Input() supercluster: Supercluster;
  @Input() count: number;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  leaves: GeoJSON.Feature<GeoJSON.Point>[];
  address:string;
  currentUser: User; 
  isAdmin: boolean = false; 

  ngOnChanges(changes: SimpleChanges) {
    this.changePage();
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
      if (this.currentUser.profile == "admin"){
        this.isAdmin = true;
        this.address = "account/admin/timelapses"
      } else{
        this.isAdmin = false;
        this.address = "account/user/timelapses"
      }
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
  styleUrls: ['./examples.css']
})
export class PopupOnClickComponent implements OnInit {
    //stories: any =[];
    earthquakes: object;
    selectedPoint: GeoJSON.Feature<GeoJSON.Point> | null;
    supercluster: Supercluster;
    selectedCluster: {
      lngLat: LngLatLike;
      count: number;
      id: number;
    };
    
  
    async ngOnInit() {
      this.earthquakes = await import('./earthquakes.geo.json');
      console.log("this earthquakes = " + this.earthquakes);
      //https://codepen.io/parry-drew/pen/wWYXmR
      //this.storyService
      //.findAllStories()
      //.subscribe(stories => { this.stories = stories }, err => console.log(err));
      //console.log("this earthquakes = " + this.earthquakes);
    }
  

  onClick(evt: MapMouseEvent) {
    this.selectedPoint = (<any>evt).features[0];
  }
}
