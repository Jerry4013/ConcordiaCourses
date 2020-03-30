package com.soen387.a2.service;

import com.soen387.a2.Model.BookModel;
import com.soen387.a2.Model.BookModelWithoutCover;
import com.soen387.a2.Model.UserModel;
import com.soen387.a2.error.BusinessException;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/11/05
 **/

public interface BookService {

    List<BookModel> listBooks();

    List<BookModel> listAllWithoutCover();

    BookModel getBookById(Integer id);

    BookModelWithoutCover getByIdWithoutCover(Integer id);

    BookModel getBookByISBN(String isbn);

    BookModel createBook(BookModel bookModel);

    BookModel updateBook(BookModel bookModel);

    void setCover(Integer id, Blob cover);

    void deleteBook(Integer id);

    void deleteAllBooks();
}
