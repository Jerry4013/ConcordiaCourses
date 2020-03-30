export class BookModel {
  public id: number;
  public title: string;
  public description: string;
  public isbn: string;
  public author: string;
  public publisher: string;
  public cover: Blob;

  constructor(id: number, title: string, description: string, isbn: string, author: string, publisher: string, cover: Blob) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.isbn = isbn;
    this.author = author;
    this.publisher = publisher;
    this.cover = cover;
  }
}
