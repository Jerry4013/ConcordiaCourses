import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmailComponent } from './Pages/email.component';

const routes: Routes = [

  {path: "**", component: EmailComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EmailRoutingModule { }
