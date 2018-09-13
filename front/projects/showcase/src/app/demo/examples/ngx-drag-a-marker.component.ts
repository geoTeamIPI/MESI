import { Component, OnInit } from '@angular/core';
import { MapMouseEvent } from 'mapbox-gl';
import { User } from "../../models/user.model";
import { Place } from "../../models/place.model";
import { PlaceService } from "../../services/place.service";

@Component({
  selector: 'showcase-demo',
  templateUrl: "ngx-drag-a-marker.component.html",
  styleUrls: ['./examples.css']
})
export class NgxDragAMarkerComponent implements OnInit {
  coordinates = [4.860940309104137, 45.761718444484416];
  color = '#3887be';
  currentUser: User;
  isAdmin: string = "notConnected";
  address: string;
  passageparmap: string = "passageparmap";
  longitude: string; 
  latitude: string; 
  placeCreated: boolean;

  //constructor(private placeService: PlaceService, private router: Router) { }

  ngOnInit(){
    this.currentUser = JSON.parse(sessionStorage.getItem("currentUser") || '{}');
    if (this.currentUser.profile == "admin") {
      this.isAdmin = "admin";
      this.address = "/account/admin/places/add/";
    } else if (this.currentUser.profile == "user") {
      this.isAdmin = "user";
      this.address = "/account/user/places/add/";
    } else {
      this.address = "/noaccount/noprofile/places/add/";
    }
    console.log("cette adresse = " + this.address);
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
    //this.createPlace();
    sessionStorage.setItem('longitude', JSON.stringify(longitude));
    sessionStorage.setItem('latitude', JSON.stringify(latitude));
    sessionStorage.setItem('passageparmap', JSON.stringify(this.passageparmap));
  }

  /*createPlace() {
    this.placeService
      .createPlaceByCoordinates(this.longitude, this.latitude, this.currentUser.id)
      .subscribe(data => this.placeCreated = true, error => this.placeCreated = false);
    this.getIdJustCreated();
    console.log("Affichage id de la place juste créée = " + this.idJustCreated);
    this.place = new Place();
    sessionStorage.removeItem("longitude");
    sessionStorage.removeItem("latitude");
    sessionStorage.setItem('idPlace', JSON.stringify(this.idJustCreated));
  }*/
}

//sessionStorage.setItem('currentUser', JSON.stringify(user));