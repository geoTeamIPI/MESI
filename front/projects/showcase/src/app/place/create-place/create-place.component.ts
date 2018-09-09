/*import { Component } from '@angular/core';
import {  ActivatedRoute } from '@angular/router';

import { Place } from '../../models/place.model';
import { PlaceService } from '../../services/place.service';

@Component({
 templateUrl: './add-place.component.html'
})
export class AddPlaceComponent {

 submitted : boolean;
 placeCreated: boolean; 
 place: Place = new Place();

 constructor( private placeService: PlaceService, route: ActivatedRoute) {}

 onSubmit(){
   this.createPlace(); 
   this.submitted = true;
 }

 createPlace(): void {
   console.log(this.place);
   this.placeService.createPlace(this.place)
       .subscribe( data => {
         this.placeCreated = true; 
         console.log("Création de l'adresse");
       }, error => {
         this.placeCreated = false; 
         console.log("Erreur de création de l'adresse"); 
       });
  };

}*/
