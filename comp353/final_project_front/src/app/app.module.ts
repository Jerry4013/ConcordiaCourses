import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './global-components/header/header.component';

import { ChatModule } from './modules/chat/chat.module';
import { SideNavComponent } from './global-components/side-nav/side-nav.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './global-components/not-found/not-found.component';
import { SharedModule } from './modules/shared/shared.module';
import { HttpClientModule } from '@angular/common/http';

import { LandingPageComponent } from './landing-page/landing-page.component';
import { EventModule } from './modules/event/event.module';
import { MatCardModule } from '@angular/material';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { EventGroupComponent } from './components/event-group/event-group.component';
import { GroupPostsComponent } from './components/group-posts/group-posts.component';
import { PostDetailsComponent } from './components/post-details/post-details.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

//services
import { GroupRepoService } from './services/group-repo/group-repo.service';
import { PostRepoService } from './services/post-repo/post-repo.service';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SideNavComponent,
    HomeComponent,
    NotFoundComponent,
    LandingPageComponent,
    EventGroupComponent,
    GroupPostsComponent,
    PostDetailsComponent,
    UserProfileComponent
  ],
  imports: [
    SharedModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ChatModule,
    HttpClientModule,
    EventModule,
    MatCardModule,
    ],
  providers: [GroupRepoService, PostRepoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
