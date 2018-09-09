import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import { MatIconRegistry } from '@angular/material';
import { BrowserModule, DomSanitizer } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { Params, RouterModule, RouterStateSnapshot, Routes } from '@angular/router';
import { EffectsModule } from '@ngrx/effects';
import { routerReducer, RouterReducerState, RouterStateSerializer, StoreRouterConnectingModule } from '@ngrx/router-store';
import { StoreModule } from '@ngrx/store';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import 'hammerjs'; 
import { NgxMapboxGLModule } from 'ngx-mapbox-gl';
import { environment } from '../environments/environment';
import { DEMO_ROUTES, DemoModule } from './demo/demo.module';
import * as fromDemo from './demo/demo.reducer';
import { HomeIndexComponent } from './home/home-index.component';
import { IndexComponent } from './index.component';
import { SharedModule } from './shared.module';

import { NgxPaginationModule } from 'ngx-pagination';

import { AddStoryComponent } from "./story/add-story/add-story.component";
import { ListStoriesComponent } from "./story/list-stories/list-stories.component";
//import { AddPlaceComponent } from "./place/add-place/add-place.component";
import { ListPlacesComponent } from "./place/list-places/list-places.component";
import { ListMyPlacesComponent } from "./place/list-myplaces/list-myplaces.component";
import { InfosPlaceComponent } from "./place/infos-place/infos-place.component";
//import { UpdatePlaceComponent } from "./place/update-place/update-place.component";
import { ListUsersComponent } from "./user/list-users/list-users.component";
import { CreateUserComponent } from "./user/create-user/create-user.component";
import { InfosUsersComponent } from "./user/infos-users/infos-users.component";
import { UpdateUserComponent } from "./user/update-user/update-user.component";
import { LoginComponent } from "./login/login.component";
import { LogoutComponent } from "./logout/logout.component";
import { AdminGuards } from "./admin.guards";
import { AdminComponent } from "./user/account/admin/admin.component";
import { NormalComponent } from "./user/account/normal/normal.component";
import { UserGuards } from "./user.guards";
import { InfosAccountComponent } from "./user/infos-account/infos-account.component";
import { UpdateAccountComponent } from "./user/update-account/update-account.component";
import { NotFoundComponent } from "./not-found/not-found.component";
import { RegisteringAccountComponent } from "./user/registering-account/registering-account.component";
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { UserService } from './services/user.service';
import { StoryService } from './services/story.service';
import { PlaceService } from './services/place.service';
import { AuthenticationService } from './services/authentication.service';
import { MatchPasswordValidatorDirective } from './user/match-password-validator.directive';

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
  { path: "account/admin", component: AdminComponent, 
    canActivate: [AdminGuards],
    children: [
          { path: "users",
           component: ListUsersComponent, 
          },
          { path: "users/add", 
            component: CreateUserComponent,
          },
          { path: "users/infos/:id", 
            component: InfosUsersComponent, 
          },
          { path: "users/update/:id", 
            component: UpdateUserComponent,     
          }, 
          {
            path: "infos", 
            component: InfosAccountComponent
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
          path: "stories/add",
          component: AddStoryComponent
        },
        {
          path: "places",
          component: ListPlacesComponent
        },
        { path: "places/infos/:id", 
          component: InfosPlaceComponent, 
        },
        {
          path: "places/user",
          component: ListMyPlacesComponent
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
          path: "update",
          component: UpdateAccountComponent
        }, 
        {
          path: "stories",
          component: ListStoriesComponent
        },
        {
          path: "stories/add",
          component: AddStoryComponent
        },
        { path: "places/infos/:id", 
          component: InfosPlaceComponent, 
        },
        {
          path: "places/user",
          component: ListMyPlacesComponent
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
    InfosUsersComponent,
    ListUsersComponent,
    UpdateUserComponent,
    ListStoriesComponent, 
    AddStoryComponent,
    ListPlacesComponent, 
    ListMyPlacesComponent, 
    InfosPlaceComponent,
    //AddPlaceComponent,
    //UpdatePlaceComponent,
    LoginComponent,
    LogoutComponent,
    AdminComponent,
    NormalComponent,
    InfosAccountComponent,
    UpdateAccountComponent,
    RegisteringAccountComponent,
    MatchPasswordValidatorDirective
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
    RouterModule.forRoot(showcaseRoutes, {enableTracing: true}),
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
    AuthenticationService,
    { provide: RouterStateSerializer, useClass: SimpleSerializer }
  ],
  bootstrap: [IndexComponent], 
  schemas: [ NO_ERRORS_SCHEMA ]
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