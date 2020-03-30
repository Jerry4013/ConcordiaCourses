import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @Output()emailSideNavOnToggleEvent = new EventEmitter();

  isLoggedIn = false;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.authService.$isLoggedIn.subscribe(
      res=>this.isLoggedIn = res
    )
  }

  openEmailSideNav():void{
    this.emailSideNavOnToggleEvent.emit("Toggle");
  }

  logOut():void{
    this.authService.logOut();
  }
  
  editProfile():void{
    this.router.navigate(['profile']);
  }
}
