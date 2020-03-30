import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {AuthService} from './auth.service';
import {ActivatedRoute, Router} from '@angular/router';
import {UserModel} from './user.model';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css']
})
export class AuthComponent implements OnInit {
  isLogin = false;
  user: UserModel;
  hasError = false;

  constructor(private authService: AuthService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  onSubmit(f: NgForm) {
    if (!f.valid) {
      return;
    }
    const value = f.value;
    this.authService.login(value.user, value.password).subscribe(data => {
      this.user = (data as UserModel);
      if (data != null) {
        this.isLogin = true;
        this.authService.isLogin = true;
        this.authService.loginStatusChanged.next(true);
        this.router.navigate(['/books'], {relativeTo: this.route});
      } else {
        this.hasError = true;
      }
    });
  }
}
