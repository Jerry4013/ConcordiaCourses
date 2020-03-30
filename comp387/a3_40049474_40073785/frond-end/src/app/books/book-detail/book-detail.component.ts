import {Component, EventEmitter, Input, OnDestroy, OnInit, Output} from '@angular/core';
import {BookModel} from '../book.model';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {BookService} from '../book.service';
import {DomSanitizer} from '@angular/platform-browser';
import {Subscription} from 'rxjs';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit, OnDestroy {
  id = 0;
  book: BookModel;
  image: any;
  isDisplayCover = true;
  deleteAllSubscription: Subscription;

  constructor(private bookService: BookService,
              private route: ActivatedRoute,
              private router: Router,
              private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params.id;
          this.book = this.bookService.getBook(this.id);
          const objectURL = 'data:image/jpeg;base64,' + this.book.cover;
          this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
        }
      );
    this.deleteAllSubscription = this.bookService.deleteAllSub.subscribe(() => {
      this.router.navigate(['../'], {relativeTo: this.route});
    });
    this.bookService.booksChanged.subscribe( () => {
      this.book = this.bookService.getBook(this.id);
      const objectURL = 'data:image/jpeg;base64,' + this.book.cover;
      this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
    });
  }

  onDeleteBook() {
    this.bookService.deleteBook(this.book.id);
    this.router.navigate(['../'], {relativeTo: this.route});
  }

  onEditBook() {
    this.router.navigate(['edit'], {relativeTo: this.route});
  }

  ngOnDestroy(): void {
    this.deleteAllSubscription.unsubscribe();
  }

  displayCover() {
    this.isDisplayCover = !this.isDisplayCover;
  }
}
