import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth/auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpRestAPIService {

  constructor(protected http: HttpClient, protected authService: AuthService) { }

  protected GET(url:string):Observable<any>{
    const options = {
      headers: {
        "X-Auth-Token": AuthService.user.token,
        "User": AuthService.user.email
      }
    }
    return this.http.get(url, options);
  }

  protected POST(url:string, data: any):Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        "X-Auth-Token": AuthService.user.token,
        "User": AuthService.user.email
      })
    };

    return this.http.post(url, data, httpOptions);
  }

  protected DELETE(url:string):Observable<any>{
    const httpOptions = {
      headers: new HttpHeaders({
        "X-Auth-Token": AuthService.user.token,
        "User": AuthService.user.email
      })
    };

    return this.http.delete(url, httpOptions);
  }
}
