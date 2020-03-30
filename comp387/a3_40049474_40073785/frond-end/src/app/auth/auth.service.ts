import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders, HttpParams} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Subject, throwError} from 'rxjs';
import { UserModel } from './user.model';
import {Router} from '@angular/router';
import {CommonreturntypeModel} from '../commonreturntype.model';
import {BookModel} from '../books/book.model';

@Injectable({providedIn: 'root'})
export class AuthService {
  user: UserModel;
  isLogin = false;
  loginStatusChanged = new Subject<boolean>();

  constructor(private http: HttpClient, private router: Router) {}

  login(username: string, password: string) {
    let params = new HttpParams();
    params = params.append('username', username);
    params = params.append('password', password);

    return this.http.get<CommonreturntypeModel>(
      'http://localhost:8080/user/login',
      {
        headers: new HttpHeaders({ 'withCredentials': 'true'}),
        params
      }
    ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
    }));
  }

}










