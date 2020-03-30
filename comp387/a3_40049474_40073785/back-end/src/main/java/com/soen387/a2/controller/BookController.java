package com.soen387.a2.controller;

import com.soen387.a2.CommonReturnType;
import com.soen387.a2.Model.BookModel;
import com.soen387.a2.Model.BookModelWithoutCover;
import com.soen387.a2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/10/20
 **/
@RestController
@RequestMapping("/book")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/list")
    public CommonReturnType getList() {
        List<BookModel> bookModels = bookService.listBooks();
        return CommonReturnType.create(bookModels);
    }

    @GetMapping(value = "/listAllWithoutCover")
    public CommonReturnType listAllWithoutCover() {
        List<BookModel> bookModels = bookService.listAllWithoutCover();
        return CommonReturnType.create(bookModels);
    }

    @GetMapping(value = "/getById")
    public CommonReturnType getBookById(@RequestParam("id") Integer id) {
        BookModel book = bookService.getBookById(id);
        return CommonReturnType.create(book);
    }

    @GetMapping(value = "/getByIdWithoutCover")
    public CommonReturnType getByIdWithoutCover(@RequestParam("id") Integer id) {
        BookModelWithoutCover byIdWithoutCover = bookService.getByIdWithoutCover(id);
        return CommonReturnType.create(byIdWithoutCover);
    }

    @GetMapping(value = "/getByISBN")
    public CommonReturnType getBookByISBN(@RequestParam("isbn") String isbn) {
        BookModel book = bookService.getBookByISBN(isbn);
        return CommonReturnType.create(book);
    }

    @PostMapping(value = "/add")
    public CommonReturnType addNewBook(@RequestParam("title") String title,
                                       @RequestParam("description") String description,
                                       @RequestParam("isbn") String isbn,
                                       @RequestParam("author") String author,
                                       @RequestParam("publisher") String publisher,
                                       @RequestParam("cover") MultipartFile cover) throws IOException {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(title);
        bookModel.setDescription(description);
        bookModel.setIsbn(isbn);
        bookModel.setAuthor(author);
        bookModel.setPublisher(publisher);
        if (cover != null) {
            byte[] bytes = cover.getBytes();
            bookModel.setCover(bytes);
        }
        BookModel newBook = bookService.createBook(bookModel);
        return CommonReturnType.create(newBook);
    }

    @PutMapping(value = "/update")
    public CommonReturnType updateBook(@RequestParam("id") String id,
                                       @RequestParam("title") String title,
                                       @RequestParam("description") String description,
                                       @RequestParam("isbn") String isbn,
                                       @RequestParam("author") String author,
                                       @RequestParam("publisher") String publisher,
                                       @RequestParam("cover") MultipartFile cover) throws IOException {
        BookModel newBook;
        BookModel bookModel;
        if (cover != null) {
            bookModel = new BookModel(Integer.parseInt(id), title, description, isbn, author, publisher,
                    cover.getBytes());
        } else {
            bookModel = new BookModel(Integer.parseInt(id), title, description, isbn, author, publisher,
                    null);
        }
        newBook = bookService.updateBook(bookModel);
        return CommonReturnType.create(newBook);
    }

    @PutMapping(value = "/cover")
    public CommonReturnType setCover(@RequestParam("id") Integer id, @RequestBody Blob cover) {
        bookService.setCover(id, cover);
        return CommonReturnType.create(null);
    }

    @DeleteMapping(value = "/delete")
    public CommonReturnType delete(@RequestParam("id") Integer id) {
        bookService.deleteBook(id);
        return CommonReturnType.create(null);
    }

    @DeleteMapping(value = "/deleteAll")
    public CommonReturnType deleteAll() {
        bookService.deleteAllBooks();
        return CommonReturnType.create(null);
    }

}
