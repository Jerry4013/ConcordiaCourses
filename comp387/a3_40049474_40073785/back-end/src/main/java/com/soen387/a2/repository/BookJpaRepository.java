package com.soen387.a2.repository;

import com.soen387.a2.Model.BookModel;
import com.soen387.a2.dataobject.Book;
import com.soen387.a2.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/
@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {

    Book findByIsbn(String isbn);
}
