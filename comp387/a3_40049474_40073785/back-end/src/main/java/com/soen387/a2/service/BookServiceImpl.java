package com.soen387.a2.service;

import com.soen387.a2.Model.BookModel;
import com.soen387.a2.Model.BookModelWithoutCover;
import com.soen387.a2.dataobject.Book;
import com.soen387.a2.repository.BookJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/11/05
 **/

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public List<BookModel> listBooks() {
        List<Book> bookList = bookJpaRepository.findAll();
        ArrayList<BookModel> bookModels = new ArrayList<>();
        for (Book book : bookList) {
            BookModel bookModel = new BookModel();
            BeanUtils.copyProperties(book, bookModel);
            if (book.getCover() != null) {
                byte[] clone = book.getCover().clone();
                bookModel.setCover(clone);
            }
            bookModels.add(bookModel);
        }
        return bookModels;
    }

    @Override
    public List<BookModel> listAllWithoutCover() {
        List<Book> bookList = bookJpaRepository.findAll();
        ArrayList<BookModel> bookModels = new ArrayList<>();
        for (Book book : bookList) {
            BookModel bookModel = new BookModel();
            BeanUtils.copyProperties(book, bookModel);
            if (book.getCover() != null) {
                bookModel.setCover(null);
            }
            bookModels.add(bookModel);
        }
        return bookModels;
    }

    @Override
    public BookModel getBookById(Integer id) {
        if (id == null) {
            return null;
        }
        Book book = bookJpaRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        }
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(book, bookModel);
        return bookModel;
    }

    @Override
    public BookModelWithoutCover getByIdWithoutCover(Integer id) {
        if (id == null) {
            return null;
        }
        Book book = bookJpaRepository.findById(id).orElse(null);
        if (book == null) {
            return null;
        }
        BookModelWithoutCover bookModelWithoutCover = new BookModelWithoutCover();
        BeanUtils.copyProperties(book, bookModelWithoutCover);
        bookModelWithoutCover.setHasImage(book.getCover() == null ? "no" : "yes");
        return bookModelWithoutCover;
    }

    @Override
    public BookModel getBookByISBN(String isbn) {
        Book book = bookJpaRepository.findByIsbn(isbn);
        BookModel bookModel = new BookModel();
        BeanUtils.copyProperties(book, bookModel);
        return bookModel;
    }

    @Override
    public BookModel createBook(BookModel bookModel) {
        if (bookModel == null) {
            return null;
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookModel, book);
        Book save = bookJpaRepository.save(book);
        BookModel newBookModel = new BookModel();
        BeanUtils.copyProperties(save, newBookModel);
        if (book.getCover() != null) {
            byte[] clone = save.getCover().clone();
            newBookModel.setCover(clone);
        }
        return newBookModel;
    }

    @Override
    @Transactional
    public BookModel updateBook(BookModel bookModel) {
        return createBook(bookModel);
    }

    @Override
    public void setCover(Integer id, Blob cover) {

    }

    @Override
    @Transactional
    public void deleteBook(Integer id) {
        if (id == null) {
            return;
        }
        bookJpaRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookJpaRepository.deleteAll();
    }
}
