import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EventListComponent } from './event-list/event-list.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import { EventDetailComponent } from './event-detail/event-detail.component';
import {MatListModule} from "@angular/material/list";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatButtonModule} from "@angular/material/button";
import {MatSnackBarModule} from "@angular/material/snack-bar";
import { MatTabsModule, MatStepperModule, MatChipsModule } from '@angular/material';
import { SharedModule } from '../shared/shared.module';
import { EventFormComponent } from './event-form/event-form.component';
import { EventRoutingModule } from './event-routing.module';
import { EventCreateDialogComponent } from './event-create-dialog/event-create-dialog.component';



@NgModule({
  declarations: [EventListComponent, EventDetailComponent,EventFormComponent, EventCreateDialogComponent],
    imports: [
        CommonModule,
        SharedModule,
        MatSidenavModule,
        MatListModule,
        MatGridListModule,
        MatExpansionModule,
        MatButtonModule,
        MatSnackBarModule,
        MatExpansionModule,
        MatTabsModule,
        EventRoutingModule,
        MatStepperModule,
        MatChipsModule
    ],
    entryComponents:[EventCreateDialogComponent]
})
export class EventModule { }
