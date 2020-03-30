import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AuthService} from '../auth/auth.service';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit, OnDestroy {
  isLogin = false;
  loginStatusChangedSub = new Subscription();
  constructor(private authService: AuthService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.loginStatusChangedSub = this.authService.loginStatusChanged.subscribe(res => {
      if (res) {
        this.isLogin = true;
      }
    });
  }

  onLogin() {
    this.router.navigate(['auth'], {relativeTo: this.route});
  }

  ngOnDestroy(): void {
    this.loginStatusChangedSub.unsubscribe();
  }
}
