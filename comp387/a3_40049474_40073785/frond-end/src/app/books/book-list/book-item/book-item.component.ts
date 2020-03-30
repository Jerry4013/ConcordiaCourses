import { Component, Input, OnInit } from '@angular/core';
import { BookModel } from '../../book.model';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.css']
})
export class BookItemComponent implements OnInit {
  image: any;
  @Input() book: BookModel;
  @Input() index: number;

  constructor(private sanitizer: DomSanitizer) { }
  ngOnInit() {
    const objectURL = 'data:image/jpeg;base64,' + this.book.cover;
    this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
  }
}
