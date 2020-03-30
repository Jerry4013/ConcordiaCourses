import {Component, Input, OnInit, Output} from '@angular/core';
import {NgForm} from '@angular/forms';
import {BookModel} from '../book.model';
import {BookService} from '../book.service';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {
  selectedFile: File = null;
  formData: FormData = new FormData();
  id: number;
  editMode = false;
  book: BookModel = new BookModel(0, '', '', '', '', '', null);
  image: any;
  constructor(private route: ActivatedRoute,
              private bookService: BookService,
              private router: Router,
              private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.route.params
      .subscribe(
        (params: Params) => {
          this.id = +params.id;
          this.editMode = params.id != null;
          if (this.editMode) {
            this.book = this.bookService.getBook(this.id);
            const objectURL = 'data:image/jpeg;base64,' + this.book.cover;
            this.image = this.sanitizer.bypassSecurityTrustUrl(objectURL);
          }
        }
      );
  }

  onSubmit(f: NgForm) {
    const value = f.value;
    this.formData.set('title', value.title);
    this.formData.set('description', value.description);
    this.formData.set('isbn', value.isbn);
    this.formData.set('author', value.author);
    this.formData.set('publisher', value.publisher);
    if (this.editMode) {
      this.formData.set('id', String(this.book.id));
      this.bookService.updateBook(this.formData);
    } else {
      this.bookService.addBook(this.formData);
    }
    this.onCancel();
  }

  onFileSelected(event) {
    this.selectedFile = event.target.files[0];
    this.formData.set('cover', this.selectedFile, this.selectedFile.name);
  }

  onCancel() {
    this.router.navigate(['../'], {relativeTo: this.route});
  }
}
