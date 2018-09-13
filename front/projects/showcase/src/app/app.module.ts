import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MatIconRegistry } from '@angular/material';
import { BrowserModule, DomSanitizer, Title } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Params, RouterModule, RouterStateSnapshot, Routes } from '@angular/router';
import { EffectsModule } from '@ngrx/effects';
import { routerReducer, RouterReducerState, RouterStateSerializer, StoreRouterConnectingModule } from '@ngrx/router-store';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { AppComponent } from './app.component';
import 'hammerjs';
import { NgxMapboxGLModule } from 'ngx-mapbox-gl';
import { environment } from '../environments/environment';
import { DEMO_ROUTES, DemoModule } from './demo/demo.module';
import * as fromDemo from './demo/demo.reducer';
import { HomeIndexComponent } from './home/home-index.component';
import { IndexComponent } from './index.component';
import { SharedModule } from './shared.module';

import { NgxPaginationModule } from 'ngx-pagination';

import { CreateStoryComponent } from "./story/create-story/create-story.component";
import { UpdateStoryComponent } from "./story/update-story/update-story.component";
import { ListStoriesComponent } from "./story/list-stories/list-stories.component";
import { ListMyStoriesComponent } from "./story/list-mystories/list-mystories.component";
import { InfosStoryComponent } from "./story/infos-story/infos-story.component";

import { CreatePlaceComponent } from "./place/create-place/create-place.component";
import { ListPlacesComponent } from "./place/list-places/list-places.component";
import { ListEmptyPlacesComponent } from "./place/list-emptyplaces/list-emptyplaces.component";
import { ListMyPlacesComponent } from "./place/list-myplaces/list-myplaces.component";
import { InfosPlaceComponent } from "./place/infos-place/infos-place.component";
import { UpdatePlaceComponent } from "./place/update-place/update-place.component";

import { CreateTimelapseComponent } from "./timelapse/create-timelapse/create-timelapse.component";
import { ProposeTimelapseComponent } from "./timelapse/propose-timelapse/propose-timelapse.component";
import { ListTimelapsesComponent } from "./timelapse/list-timelapses/list-timelapses.component";
import { ListTimelapsesApproveComponent } from "./timelapse/list-timelapsesapprove/list-timelapsesapprove.component";
import { InfosTimelapseComponent } from "./timelapse/infos-timelapse/infos-timelapse.component";
import { UpdateTimelapseComponent } from "./timelapse/update-timelapse/update-timelapse.component";

import { CreateTypeComponent } from "./type/create-type/create-type.component";
import { ProposeTypeComponent } from "./type/propose-type/propose-type.component";
import { ListTypesComponent } from "./type/list-types/list-types.component";
import { ListTypesApproveComponent } from "./type/list-typesapprove/list-typesapprove.component";
import { InfosTypeComponent } from "./type/infos-type/infos-type.component";
import { UpdateTypeComponent } from "./type/update-type/update-type.component";

import { ListUsersComponent } from "./user/list-users/list-users.component";
import { CreateUserComponent } from "./user/create-user/create-user.component";
import { InfosUserComponent } from "./user/infos-user/infos-user.component";
import { InfosUserPublicComponent } from "./user/infos-userpublic/infos-userpublic.component";
import { UpdateUserComponent } from "./user/update-user/update-user.component"; 

import { LoginComponent } from "./login/login.component";
import { LogoutComponent } from "./logout/logout.component";
import { AdminGuards } from "./admin.guards";
import { AdminComponent } from "./user/account/admin/admin.component";
import { NormalComponent } from "./user/account/normal/normal.component";
import { UserGuards } from "./user.guards";
import { RegisteringAccountComponent } from "./user/registering-account/registering-account.component";
import { MatchPasswordValidatorDirective } from './user/match-password-validator.directive';

import { InfosAccountComponent } from "./user/infos-account/infos-account.component";
import { InfosPublicAccountComponent } from "./user/infos-publicaccount/infos-publicaccount.component";
import { UpdateAccountComponent } from "./user/update-account/update-account.component";

import { NotFoundComponent } from "./not-found/not-found.component";
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { UserService } from './services/user.service';
import { StoryService } from './services/story.service';
import { PlaceService } from './services/place.service';
import { TimelapseService } from './services/timelapse.service';
import { TypeService } from './services/type.service';
import { AuthenticationService } from './services/authentication.service';


export interface RouterStateUrl {
  url: string;
  params: Params;
  queryParams: Params;
}

export interface State {
  router: RouterReducerState<RouterStateUrl>;
  demo: fromDemo.State;
}

export class SimpleSerializer implements RouterStateSerializer<RouterStateUrl> {
  serialize(routerState: RouterStateSnapshot): RouterStateUrl {
    let route = routerState.root;
    while (route.firstChild) {
      route = route.firstChild;
    }
    const { url, root: { queryParams } } = routerState;
    const { params } = route;
    return { url, params, queryParams };
  }
}

export const showcaseRoutes: Routes = [
  {
    path: 'demo',
    children: DEMO_ROUTES
  },
  {
    path: '',
    children: [{
      path: '',
      component: HomeIndexComponent
    }],
    pathMatch: 'full'
  },
  {
    path: 'doc',
    loadChildren: './doc/doc.module#DocModule'
  },
  { path: "logout", component: LogoutComponent },

  { path: "login", component: LoginComponent },
  {
    path: "noaccount/display/stories",
    component: ListStoriesComponent
  },
  {
    path: "noaccount/display/stories/infos/:id",
    component: InfosStoryComponent
  },
  {
    path: "account/admin", component: AdminComponent,
    canActivate: [AdminGuards],
    children: [
      {
        path: "users",
        component: ListUsersComponent,
      },
      {
        path: "users/add",
        component: CreateUserComponent,
      },
      {
        path: "users/infos/:id",
        component: InfosUserComponent,
      },
      {
        path: "users/infos/public/:id",
        component: InfosUserPublicComponent,
      },
      {
        path: "users/update/:id",
        component: UpdateUserComponent,
      },
      {
        path: "infos",
        component: InfosAccountComponent
      },
      {
        path: "infos/public",
        component: InfosPublicAccountComponent
      },
      {
        path: "update",
        component: UpdateAccountComponent
      },
      {
        path: "stories",
        component: ListStoriesComponent
      },
      {
        path: "stories/user",
        component: ListMyStoriesComponent
      },
      {
        path: "stories/add",
        component: CreateStoryComponent
      },
      {
        path: "stories/update/:id",
        component: UpdateStoryComponent
      },
      {
        path: "stories/infos/:id",
        component: InfosStoryComponent,
      },
      {
        path: "places",
        component: ListPlacesComponent
      },
      {
        path: "places/infos/:id",
        component: InfosPlaceComponent,
      },
      {
        path: "places/user",
        component: ListMyPlacesComponent
      },
      {
        path: "places/add",
        component: CreatePlaceComponent
      },
      {
        path: "places/update/:id",
        component: UpdatePlaceComponent
      },
      {
        path: "places/compare",
        component: ListEmptyPlacesComponent
      },
      {
        path: "timelapses",
        component: ListTimelapsesComponent
      },
      {
        path: "timelapses/add",
        component: CreateTimelapseComponent
      },
      {
        path: "timelapses/approve",
        component: ListTimelapsesApproveComponent
      },
      {
        path: "timelapses/update/:id",
        component: UpdateTimelapseComponent
      },
      {
        path: "timelapses/infos/:id",
        component: InfosTimelapseComponent
      },
      {
        path: "types",
        component: ListTypesComponent
      },
      {
        path: "types/add",
        component: CreateTypeComponent
      },
      {
        path: "types/approve",
        component: ListTypesApproveComponent
      },
      {
        path: "types/update/:id",
        component: UpdateTypeComponent
      },
      {
        path: "types/infos/:id",
        component: InfosTypeComponent
      }
    ]
  },
  {
    path: "account/user",
    component: NormalComponent,
    canActivate: [UserGuards],
    children: [
      {
        path: "infos",
        component: InfosAccountComponent
      },
      {
        path: "infos/public",
        component: InfosPublicAccountComponent
      },
      {
        path: "update",
        component: UpdateAccountComponent
      },
      {
        path: "stories",
        component: ListStoriesComponent
      },
      {
        path: "stories/user",
        component: ListMyStoriesComponent
      },
      {
        path: "stories/update/:id",
        component: UpdateStoryComponent
      },
      {
        path: "stories/add",
        component: CreateStoryComponent
      },
      {
        path: "stories/infos/:id",
        component: InfosStoryComponent,
      },
      {
        path: "places",
        component: ListPlacesComponent
      },
      {
        path: "places/infos/:id",
        component: InfosPlaceComponent
      },
      {
        path: "places/user",
        component: ListMyPlacesComponent
      },
      {
        path: "places/add",
        component: CreatePlaceComponent
      },
      {
        path: "places/update/:id",
        component: UpdatePlaceComponent
      },
      {
        path: "places/compare",
        component: ListEmptyPlacesComponent
      },
      {
        path: "users",
        component: ListUsersComponent,
      },
      {
        path: "users/infos/public/:id",
        component: InfosUserPublicComponent,
      },
      {
        path: "timelapses",
        component: ListTimelapsesComponent
      },
      {
        path: "timelapses/add",
        component: ProposeTimelapseComponent
      },
      {
        path: "timelapses/update/:id",
        component: UpdateTimelapseComponent
      },
      {
        path: "timelapses/infos/:id",
        component: InfosTimelapseComponent
      },
      {
        path: "types",
        component: ListTypesComponent
      },
      {
        path: "types/add",
        component: ProposeTypeComponent
      },
      {
        path: "types/update/:id",
        component: UpdateTypeComponent
      },
      {
        path: "types/infos/:id",
        component: InfosTypeComponent
      }
    ]
  },
  {
    path: "registering",
    component: RegisteringAccountComponent
  },
  {
    path: "404",
    component: NotFoundComponent
  },
  {
    path: "**",
    redirectTo: "404"
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  declarations: [
    IndexComponent,
    HomeIndexComponent,
    NotFoundComponent,
    CreateUserComponent,
    InfosUserComponent,
    InfosUserPublicComponent,
    ListUsersComponent,
    UpdateUserComponent,
    ListStoriesComponent,
    ListMyStoriesComponent,
    CreateStoryComponent,
    UpdateStoryComponent,
    InfosStoryComponent,
    ListPlacesComponent,
    ListEmptyPlacesComponent,
    ListMyPlacesComponent,
    InfosPlaceComponent,
    CreatePlaceComponent,
    UpdatePlaceComponent,
    LoginComponent,
    LogoutComponent,
    AdminComponent,
    NormalComponent,
    InfosAccountComponent,
    InfosPublicAccountComponent,
    UpdateAccountComponent,
    RegisteringAccountComponent,
    MatchPasswordValidatorDirective,
    CreateTimelapseComponent,
    ProposeTimelapseComponent,
    ListTimelapsesComponent,
    ListTimelapsesApproveComponent,
    InfosTimelapseComponent,
    UpdateTimelapseComponent,
    CreateTypeComponent,
    ProposeTypeComponent,
    ListTypesComponent,
    ListTypesApproveComponent,
    InfosTypeComponent,
    UpdateTypeComponent,
    AppComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    SharedModule,
    DemoModule,
    ReactiveFormsModule,
    FormsModule,
    NgxPaginationModule,
    StoreModule.forRoot({
      router: <any>routerReducer
    }),
    RouterModule.forRoot(showcaseRoutes, { enableTracing: true }),
    EffectsModule.forRoot([]),
    !environment.production ? StoreDevtoolsModule.instrument() : [],
    StoreRouterConnectingModule.forRoot({
      stateKey: 'router'
    }),
    NgxMapboxGLModule.withConfig({
      accessToken: 'pk.eyJ1Ijoid3lra3NzIiwiYSI6ImNqMjR6aTdmdzAwNHMzMnBvbjBucjlqNm8ifQ.6GjGpofWBVaIuSnhdXQb5w'
    })
  ],
  providers: [
    UserService,
    StoryService,
    PlaceService,
    TimelapseService,
    TypeService,
    Title,
    AuthenticationService,
    { provide: RouterStateSerializer, useClass: SimpleSerializer }
  ],
  bootstrap: [IndexComponent, AppComponent],
  schemas: [NO_ERRORS_SCHEMA]
})
export class AppModule {
  constructor(
    iconRegistry: MatIconRegistry,
    sanitizer: DomSanitizer
  ) {
    iconRegistry.addSvgIcon('ngx-mapbox-gl', sanitizer.bypassSecurityTrustResourceUrl('assets/ngx-mapbox-gl.svg'));
    iconRegistry.addSvgIcon('ngx-mapbox-gl-red', sanitizer.bypassSecurityTrustResourceUrl('assets/ngx-mapbox-gl-red.svg'));
    iconRegistry.addSvgIcon('github', sanitizer.bypassSecurityTrustResourceUrl('assets/github.svg'));
  }
} 