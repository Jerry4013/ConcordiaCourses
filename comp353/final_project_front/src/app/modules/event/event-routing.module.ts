import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EventListComponent } from './event-list/event-list.component';
import { EventDetailComponent } from './event-detail/event-detail.component';

const routes: Routes = [
  {path: "", redirectTo:"list", pathMatch:"full"},
  {path: 'list', component: EventListComponent},
  {path: 'detail/:id', component: EventDetailComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EventRoutingModule { }
