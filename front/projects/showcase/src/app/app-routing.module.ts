import { NgModule, Component } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { StoryComponent } from "./story/story.component";
import { AddStoryComponent } from "./story/add-story/add-story.component";
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

const routes: Routes = [
  {
    path: "",
    redirectTo: "/",
    pathMatch: "full"
  },
  //{ path: "logout", redirectTo: "/" },
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
          component: StoryComponent
        },
        {
          path: "stories/create",
          component: AddStoryComponent
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
          component: StoryComponent
        },
        {
          path: "stories/create",
          component: AddStoryComponent
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
    }
];

@NgModule({
  exports: [RouterModule],
  imports: [
    RouterModule.forRoot(
      routes,
      { enableTracing: true } // <-- debugging purposes only
    )
  ]
})
export class AppRoutingModule {}
