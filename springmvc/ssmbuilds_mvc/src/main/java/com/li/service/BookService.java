package com.li.service;

import com.li.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    // 增加
    int addBook(Books books);

    // 删除
    int deleteBookById(int id);

    // 跟新
    int updateBook(Books books);

    // 查询一本书
    Books queryBookById(int id);

    // 查询全部
    List<Books> queryAllBook();

    List<Books> queryBookName(String bookname);
}
