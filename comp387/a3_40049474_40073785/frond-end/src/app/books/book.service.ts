import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {CommonreturntypeModel} from '../commonreturntype.model';
import {BookModel} from './book.model';
import {map} from 'rxjs/operators';
import {Subject} from 'rxjs';
import {Injectable} from '@angular/core';

@Injectable()
export class BookService {
  private books: BookModel[] = [];
  booksChanged = new Subject<BookModel[]>();
  deleteAllSub = new Subject();
  constructor(private http: HttpClient) {
    this.books = this.getBookListFromServer();
  }

  getBookListFromServer() {
     this.http
      .get<CommonreturntypeModel>(
        'http://localhost:8080/book/list',
        {
          headers: new HttpHeaders({ 'withCredentials': 'true'}),
        }
      ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
      })).subscribe(data => {
       this.books = (data as BookModel[]);
       this.booksChanged.next(this.books.slice());
      });
     return this.books.slice();
  }

  getBookList() {
    return this.books.slice();
  }

  getBook(index: number) {
    return this.books[index];
  }

  addBook(formData: FormData) {
    this.http
      .post<CommonreturntypeModel>(
        'http://localhost:8080/book/add',
        formData,
        {
          headers: new HttpHeaders({ 'withCredentials': 'true'}),
        }
      ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
    }))
      .subscribe( res => {
        this.books.push(res as BookModel);
        this.booksChanged.next(this.books.slice());
      });
  }

  updateBook(formData: FormData) {
    this.http
      .put<CommonreturntypeModel>(
        'http://localhost:8080/book/update',
        formData,
        {
          headers: new HttpHeaders({ 'withCredentials': 'true'}),
        }
      ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
    }))
      .subscribe( res => {
        const index = this.books.findIndex(book => book.id === (res as BookModel).id);
        this.books[index] = res as BookModel;
        this.booksChanged.next(this.books.slice());
      });
  }


  deleteBook(id: number) {
    let params = new HttpParams();
    params = params.append('id', String(id));
    this.http
      .delete<CommonreturntypeModel>(
        'http://localhost:8080/book/delete',
        {
          headers: new HttpHeaders({ 'withCredentials': 'true'}),
          params
        }
      ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
    }))
      .subscribe( () => {
        const index = this.books.findIndex(book => book.id === id);
        this.books.splice(index, 1);
        this.booksChanged.next(this.books.slice());
      });
  }


  deleteAll() {
    this.http
      .delete<CommonreturntypeModel>(
        'http://localhost:8080/book/deleteAll',
        {
          headers: new HttpHeaders({ 'withCredentials': 'true'}),
        }
      ).pipe(map(responseData => {
      if (responseData.status === 'success') {
        return responseData.data;
      }
    }))
      .subscribe( () => {
        this.books = [];
        this.deleteAllSub.next();
        this.booksChanged.next(this.books.slice());
      });
  }
}
