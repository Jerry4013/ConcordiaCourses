import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './global-components/not-found/not-found.component';

import { EventGroupComponent } from './components/event-group/event-group.component';
import { GroupPostsComponent } from './components/group-posts/group-posts.component';
import { PostDetailsComponent } from './components/post-details/post-details.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { AuthGuardService } from './services/route-guards/auth-guard.service';
import { HideLoginService } from './services/route-guards/hide-login.service';
import { UserProfileComponent } from './user-profile/user-profile.component';

const routes: Routes = [
  {path: "", redirectTo:"home",pathMatch:"full"},
  {path: "auth", component: LandingPageComponent, canActivate:[HideLoginService]},
  {path: "home", component: HomeComponent, canActivate:[AuthGuardService]},
  {path: "group/:eventId", component: EventGroupComponent, canActivate:[AuthGuardService]},
  {path: "posts/:groupId", component: GroupPostsComponent,canActivate:[AuthGuardService]},
  {path: "post/:postId", component: PostDetailsComponent,canActivate:[AuthGuardService]},
  {path: "email", loadChildren: () => import('./modules/email/email.module').then(m=>m.EmailModule),canActivate:[AuthGuardService]},
  {path: "profile", component: UserProfileComponent, canActivate: [AuthGuardService]},
  {path: "event", loadChildren: () => import('./modules/event/event.module').then(m=>m.EventModule),canActivate:[AuthGuardService]},
  {path: "**", component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
