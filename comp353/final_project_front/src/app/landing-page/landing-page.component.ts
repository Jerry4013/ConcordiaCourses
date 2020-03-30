import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { AuthService } from '../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.scss']
})
export class LandingPageComponent implements OnInit {

  email = new FormControl('', [Validators.required, Validators.email]);
  password = new FormControl('', [Validators.required]);

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  signUp():void{
    // this.authService.logIn(this.email.value, this.password.value).subscribe(
    //   res=>{
    //     console.log(res);
    //   }
    // )
  }

  signIn():void{
    if(this.email.invalid || this.password.invalid) return;

    this.authService.logIn(this.email.value, this.password.value).subscribe(
      null,
      err=>{
        this.password.setErrors({error: err.error});
        console.log(err)
      }
    )
  }
}
