import {Component, OnInit, ViewChild} from '@angular/core';
import {BookDetailComponent} from './book-detail/book-detail.component';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  constructor() { }

  ngOnInit() {
  }

}
