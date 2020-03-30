import { Injectable, OnInit } from '@angular/core';
import { UserProfile } from 'src/app/data-models/user-profile';
import { Subject, Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../../environments/environment'; 
import { tap } from 'rxjs/operators';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  static user: UserProfile;

  $isLoggedIn = new Subject<boolean>();
  
  constructor(private http: HttpClient, private router: Router) {
  }

  isAuthenticated():boolean{
    const userData = localStorage.getItem("user");

    if(userData){
      AuthService.user = JSON.parse(userData);
      this.$isLoggedIn.next(true);
      return true;
    }

    this.$isLoggedIn.next(false);
    return false;
  }

  isAdmin():boolean{
    return AuthService.user.role === 'Admin';
  }

  getUserProfile(): UserProfile {
    return AuthService.user;
  }

  logIn(email:string, password:string):Observable<any>{
    return this.http.post(environment.path.signInAPI, {email, password}).pipe(
      tap(res=>{
        if(res.email){
          AuthService.user = res;
          this.$isLoggedIn.next(true);
          this.router.navigate(['/home']);

          localStorage.setItem("user", JSON.stringify(res));
        }
      })
    );
  }

  logOut():void{
    AuthService.user = null;
    localStorage.setItem("user", "");
    this.$isLoggedIn.next(false);
    this.router.navigate(['auth']);
  }
}
