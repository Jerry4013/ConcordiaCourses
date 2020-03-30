package com.soen387.a2.Model;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/11/05
 **/
public class BookModelWithoutCover {

    private Integer id;

    private String title;

    private String description;

    private String isbn;

    private String author;

    private String publisher;

    private String hasImage;

    public BookModelWithoutCover() {
    }

    public BookModelWithoutCover(Integer id, String title, String description, String isbn, String author,
                                 String publisher, String hasImage) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.hasImage = hasImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getHasImage() {
        return hasImage;
    }

    public void setHasImage(String hasImage) {
        this.hasImage = hasImage;
    }
}
