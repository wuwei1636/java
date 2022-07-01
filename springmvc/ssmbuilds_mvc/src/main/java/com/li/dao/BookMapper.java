package com.li.dao;

import com.li.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    // 增加
    int addBook(Books books);

    // 删除
    int deleteBookById(@Param("bookId") int id);

    // 跟新
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(@Param("bookId") int id);

    // 查询全部
    List<Books> queryAllBook();

    List<Books> queryBookName(@Param("bookName") String bookname);
}
