import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmailComponent } from './Pages/email.component';
import { EmailRoutingModule } from './email-routing.module';
import { EmailFoldersComponent } from './email-folders/email-folders.component';
import { EmailListComponent } from './email-list/email-list.component';
import { EmailDetailComponent } from './email-detail/email-detail.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatButtonModule} from "@angular/material/button";
import {MatSliderModule} from "@angular/material/slider";
import {MatIconModule} from "@angular/material/icon";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [EmailComponent, EmailFoldersComponent, EmailListComponent, EmailDetailComponent],
  imports: [
    CommonModule,
    EmailRoutingModule,
    MatSidenavModule,
    MatListModule,
    MatButtonModule,
    MatSliderModule,
    MatIconModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule
  ]
})
export class EmailModule { }
