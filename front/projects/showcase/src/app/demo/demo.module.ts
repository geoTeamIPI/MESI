import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EffectsModule } from '@ngrx/effects';
import { StoreModule } from '@ngrx/store';


import { MglResizeEventEmitter } from 'ngx-mapbox-gl';
import { SharedModule } from '../shared.module';
import { DemoFileLoaderService } from './demo-file-loader.service';
import { DemoIndexComponent } from './demo-index.component';
import { DemoEffects } from './demo.effects';
import * as fromDemo from './demo.reducer';
import { Display3dBuildingsComponent } from './examples/3d-buildings.component';
import { AddImageGeneratedComponent } from './examples/add-image-generated.component';
import { AddImageComponent } from './examples/add-image.component';
import { AttributionPositionComponent } from './examples/attribution-position.component';
import { CenterOnSymbolComponent } from './examples/center-on-symbol.component';
import { ClusterComponent } from './examples/cluster.component';
import { CustomMarkerIconsComponent } from './examples/custom-marker-icons.component';
import { CustomStyleIdComponent } from './examples/custom-style-id.component';
import { DisplayMapComponent } from './examples/display-map.component';
import { FullscreenComponent } from './examples/fullscreen.component'; 
import { GeoJSONLineComponent } from './examples/geojson-line.component';
import { HeatMapComponent } from './examples/heatmap.component';
import { HoverStylesComponent } from './examples/hover-styles.component';
import { InteractiveFalseComponent } from './examples/interactive-false.component';
import { LanguageSwitchComponent } from './examples/language-switch.component';
import { LiveUpdateFeatureComponent } from './examples/live-update-feature.component';
import { LocateUserComponent } from './examples/locate-user.component';
import { MapboxGlGeocoderComponent } from './examples/mapbox-gl-geocoder.component';
import { NavigationComponent } from './examples/navigation.component';
import { NgxCustomControlComponent } from './examples/ngx-custom-control.component';
import { NgxCustomMarkerIconsComponent } from './examples/ngx-custom-marker-icons.component';
import { NgxDragAMarkerComponent } from './examples/ngx-drag-a-marker.component';
import { NgxDragAPointComponent } from './examples/ngx-drag-a-point.component';
import { NgxGeoJSONLineComponent } from './examples/ngx-geojson-line.component';
import { ClusterPopupComponent, NgxMarkerClusterComponent } from './examples/ngx-marker-cluster.component';
import { NgxScaleControlComponent } from './examples/ngx-scale-control.component';
import { PopupOnClickComponent } from './examples/popup-on-click.component';
import { PopupComponent } from './examples/popup.component';
import { SatelliteMapComponent } from './examples/satellite-map.component';
import { SetPopupComponent } from './examples/set-popup.component';
import { SetStyleComponent } from './examples/set-style.component';
import { ToggleLayersComponent } from './examples/toggle-layers.component';
import { ZoomtoLinestringComponent } from './examples/zoomto-linestring.component';
import { StackblitzEditGuard } from './stackblitz-edit/stackblitz-edit-guard.service';
import { StackblitzEditComponent } from './stackblitz-edit/stackblitz-edit.component';
import { DisplayPlaceComponent } from './examples/display-place-component';


export enum Category {
  PROFILE = 'User',
  STORIES = 'Stories'
}

// tslint:disable:max-line-length
export const DEMO_ROUTES: Routes = [
  {
    path: '',
    component: DemoIndexComponent,
    children: [
      { path: 'edit/:demoUrl', component: StackblitzEditComponent, canActivate: [StackblitzEditGuard] },
      { path: 'display-map', component: DisplayMapComponent, data: { label: 'Show Stories MAP', cat: Category.STORIES } },
      { path: 'create-new-place', component: NgxDragAMarkerComponent, data: { label: 'Create a new place', cat: Category.STORIES } },
      //{ path: 'create-story', component: DisplayPlaceComponent, data: { label: 'Show places MAP', cat: Category.STORIES } }
      //{ path: 'update-story', component: UpdateStoryComponent}
      
      // { path: 'set-style', component: SetStyleComponent, data: { label: 'Change a map\'s style', cat: Category.STYLES } },
      // { path: 'satellite-map', component: SatelliteMapComponent, data: { label: 'Display a satellite map', cat: Category.STYLES } },
      // { path: 'add-image-generated', component: AddImageGeneratedComponent, data: { label: 'Add a generated icon to the map', cat: Category.LAYERS } },
      // { path: 'add-image', component: AddImageComponent, data: { label: 'Add an icon to the map', cat: Category.LAYERS } },
      // { path: 'toggle-layers', component: ToggleLayersComponent, data: { label: 'Show and hide layers', cat: Category.LAYERS } },
      // { path: '3d-buildings', component: Display3dBuildingsComponent, data: { label: 'Display 3d buildings', cat: Category.LAYERS } },
      // { path: 'cluster', component: ClusterComponent, data: { label: 'Create and style clusters', cat: Category.LAYERS } },
      // { path: 'heatmap', component: HeatMapComponent, data: { label: 'Create a heatmap layer', cat: Category.LAYERS } },
      // { path: 'geojson-line', component: GeoJSONLineComponent, data: { label: 'Add a GeoJSON line', cat: Category.LAYERS } },
      // { path: 'ngx-geojson-line', component: NgxGeoJSONLineComponent, data: { label: '[NGX] Add a GeoJSON line', cat: Category.LAYERS } },
      // { path: 'custom-marker-icons', component: CustomMarkerIconsComponent, data: { label: 'Add custom icons with Markers', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'ngx-custom-marker-icons', component: NgxCustomMarkerIconsComponent, data: { label: '[NGX] Add custom icons with Markers', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'live-update-feature', component: LiveUpdateFeatureComponent, data: { label: 'Update a feature in realtime', cat: Category.SOURCES } },
      // { path: 'popup', component: PopupComponent, data: { label: 'Display a popup', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'set-popup', component: SetPopupComponent, data: { label: 'Attach a popup to a marker instance', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'fullscreen', component: FullscreenComponent, data: { label: 'View a fullscreen map', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'navigation', component: NavigationComponent, data: { label: 'Display map navigation controls', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'locate-user', component: LocateUserComponent, data: { label: 'Locate the user', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'attribution-position', component: AttributionPositionComponent, data: { label: 'Change the default position for attribution', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'ngx-scale-control', component: NgxScaleControlComponent, data: { label: '[NGX] Show scale information', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'ngx-custom-control', component: NgxCustomControlComponent, data: { label: '[NGX] Add a custom control', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'interactive-false', component: InteractiveFalseComponent, data: { label: 'Display a non-interactive map', cat: Category.USER_INTERACTION } },
      // { path: 'language-switch', component: LanguageSwitchComponent, data: { label: 'Change a map\'s language', cat: Category.USER_INTERACTION } },
      // { path: 'center-on-symbol', component: CenterOnSymbolComponent, data: { label: 'Center the map on a clicked symbol', cat: Category.USER_INTERACTION } },
      // { path: 'ngx-drag-a-point', component: NgxDragAPointComponent, data: { label: '[NGX] Create a draggable point', cat: Category.USER_INTERACTION } },
      // { path: 'ngx-drag-a-marker', component: NgxDragAMarkerComponent, data: { label: '[NGX] Create a draggable marker', cat: Category.USER_INTERACTION } },
      // { path: 'hover-styles', component: HoverStylesComponent, data: { label: 'Create a hover effect', cat: Category.USER_INTERACTION } },
      // { path: 'popup-on-click', component: PopupOnClickComponent, data: { label: 'Display a popup on click', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'zoomto-linestring', component: ZoomtoLinestringComponent, data: { label: 'Fit to the bounds of a LineString', cat: Category.USER_INTERACTION } },
      // { path: 'ngx-marker-cluster', component: NgxMarkerClusterComponent, data: { label: '[NGX] Create a clusters of html markers', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: 'mapbox-gl-geocoder', component: MapboxGlGeocoderComponent, data: { label: 'Add a geocoder', cat: Category.CONTROLS_AND_OVERLAYS } },
      // { path: '**', redirectTo: 'display-map' }, 
    ]
  }
];

@NgModule({
  imports: [
    SharedModule,
    RouterModule,
    StoreModule.forFeature('demo', fromDemo.reducer),
    EffectsModule.forFeature([DemoEffects])
  ],
  providers: [
    StackblitzEditGuard,
    DemoFileLoaderService,
    { provide: MglResizeEventEmitter, useExisting: DemoEffects }, // Please don't mind me (╭ರ_⊙)
  ],
  declarations: [
    DemoIndexComponent,
    StackblitzEditComponent,
    DisplayMapComponent,
    CustomStyleIdComponent,
    SetStyleComponent,
    SatelliteMapComponent,
    AddImageGeneratedComponent,
    AddImageComponent,
    ToggleLayersComponent,
    ClusterComponent,
    HeatMapComponent,
    GeoJSONLineComponent,
    NgxGeoJSONLineComponent,
    CustomMarkerIconsComponent,
    NgxCustomMarkerIconsComponent,
    LiveUpdateFeatureComponent,
    PopupComponent,
    SetPopupComponent,
    FullscreenComponent,
    NavigationComponent,
    LocateUserComponent,
    MapboxGlGeocoderComponent,
    AttributionPositionComponent,
    NgxScaleControlComponent,
    NgxCustomControlComponent,
    InteractiveFalseComponent,
    LanguageSwitchComponent,
    CenterOnSymbolComponent,
    NgxDragAPointComponent,
    NgxDragAMarkerComponent,
    HoverStylesComponent,
    PopupOnClickComponent,
    ZoomtoLinestringComponent,
    NgxMarkerClusterComponent,
    ClusterPopupComponent,
    Display3dBuildingsComponent
  ]
})
export class DemoModule { }
