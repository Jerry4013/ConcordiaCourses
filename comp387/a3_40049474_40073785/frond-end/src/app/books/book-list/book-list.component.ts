import {Component, OnDestroy, OnInit} from '@angular/core';
import {BookModel} from '../book.model';
import {BookService} from '../book.service';
import {Subject, Subscription} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit, OnDestroy {
  bookSubscription: Subscription;
  books: BookModel[] = this.bookService.getBookListFromServer();
  constructor(private bookService: BookService,
              private router: Router,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.bookSubscription = this.bookService.booksChanged
      .subscribe(
        (books: BookModel[]) => {
          this.books = books;
        }
      );
    this.books = this.bookService.getBookList();
  }

  onNewBook() {
    this.router.navigate(['new'], {relativeTo: this.route});
  }

  deleteAll() {
    this.bookService.deleteAll();
  }

  ngOnDestroy(): void {
    this.bookSubscription.unsubscribe();
  }
}
