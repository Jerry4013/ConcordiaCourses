import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BooksComponent} from './books/books.component';
import {AuthComponent} from './auth/auth.component';
import {BookEditComponent} from './books/book-edit/book-edit.component';
import {BookDetailComponent} from './books/book-detail/book-detail.component';
import {BookStartComponent} from './books/book-start/book-start.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/auth', pathMatch: 'full' },
  { path: 'books',
    component: BooksComponent,
    children: [
      { path: '', component: BookStartComponent },
      { path: 'new', component: BookEditComponent },
      { path: ':id', component: BookDetailComponent },
      { path: ':id/edit', component: BookEditComponent }
    ]},
  { path: 'auth', component: AuthComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
