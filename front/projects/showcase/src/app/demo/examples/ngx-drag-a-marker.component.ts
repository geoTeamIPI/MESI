import { Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { MapMouseEvent } from 'mapbox-gl';
import { User } from "../../models/user.model";
import { MatPaginator, PageEvent } from '@angular/material';
import { Cluster, Supercluster } from 'supercluster';
import { Place } from "../../models/place.model";
import { LngLatLike } from 'mapbox-gl';
import { PlaceService } from "../../services/place.service";
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
  templateUrl: "ngx-drag-a-marker.component.html",
  styleUrls: ['./examples.css']
})
export class NgxDragAMarkerComponent implements OnInit {
  earthquakes: object;
  coordinates = [4.860940309104137, 45.761718444484416];
  color = '#3887be';
  currentUser: User;
  isAdmin: string = "notConnected";
  urlTo: string;
  address: string; 
  addressend: string;
  coordinatesdisplay: string; 
  passageparmap: string = "passageparmap";
  passageparmapshortcut: string = "passageparmapshortcut";
  selectedPoint: GeoJSON.Feature<GeoJSON.Point> | null;
  longitude: string; 
  latitude: string; 
  idPlace: number; 
  urlToShortcut: string; 
  placeCreated: boolean;
  idSelectedPlace: number; 
  supercluster: Supercluster;
  selectedCluster: {
    lngLat: LngLatLike;
    count: number;
    id: number;
  };

  constructor(private storyService: StoryService, private route: ActivatedRoute, private router: Router) { }

  async ngOnInit(){
    this.earthquakes = await import('./dataplace.geo.json');
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = "admin";
      this.urlTo = "/account/admin/places/add/";
      this.urlToShortcut = "/account/admin/stories/add/";
    } else if (this.currentUser.profile == "user") {
      this.isAdmin = "user";
      this.urlTo = "/account/user/places/add/";
      this.urlToShortcut = "/account/user/stories/add/";
    } 
    console.log("cette adresse = " + this.urlTo);
    console.log("mes points sont = ", this.earthquakes);
  }

  onDragStart(event: MapMouseEvent) {
    console.log('onDragStart', event);
  }

  onDragEnd(event: MapMouseEvent) {
    console.log('onDragEnd', event);
  }

  onDrag(event: MapMouseEvent) { 
    console.log('onDrag', event);
    this.coordinates = event.lngLat.toArray();
  }

  validateCoordinates(longitude: string, latitude:string){
    this.longitude = longitude;
    this.latitude = latitude; 
    sessionStorage.setItem('longitude', JSON.stringify(longitude));
    sessionStorage.setItem('latitude', JSON.stringify(latitude));
    sessionStorage.setItem('passageparmap', JSON.stringify(this.passageparmap));
  }

  onClick(evt: MapMouseEvent) {
    this.selectedPoint = (<any>evt).features[0];
    this.idSelectedPlace = (<any>evt).features[0].properties.id;
    this.address = (<any>evt).features[0].properties.streetnumber + ", " + (<any>evt).features[0].properties.street
    this.addressend =  (<any>evt).features[0].properties.zipcode + " " + (<any>evt).features[0].properties.city;
    this.coordinatesdisplay = "[" + (<any>evt).features[0].geometry.coordinates + "]";
    sessionStorage.setItem('passageparmapshortcut', JSON.stringify(this.passageparmapshortcut));
    this.longitude=(<any>evt).features[0].geometry.coordinates[0];
    this.latitude=(<any>evt).features[0].geometry.coordinates[1];
    sessionStorage.setItem('longitude', JSON.stringify(this.longitude));
    sessionStorage.setItem('latitude', JSON.stringify(this.latitude));
  }

}
