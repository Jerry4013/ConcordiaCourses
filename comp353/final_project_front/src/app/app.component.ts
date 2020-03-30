import { Component, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material';
import { AuthService } from './services/auth/auth.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'comp353-final-proj';

  @ViewChild('sidenav', {static: false}) sidenav: MatSidenav;

  isLoggedIn = false;

  constructor(private authService: AuthService){
    this.authService.$isLoggedIn.subscribe(
      isLoggedIn => {
        this.isLoggedIn = isLoggedIn;
        if(!isLoggedIn) this.close();
      }
    )
  }

  close() {
    this.sidenav.close();
  }
}
