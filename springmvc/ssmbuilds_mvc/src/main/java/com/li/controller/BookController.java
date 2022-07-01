package com.li.controller;

import com.li.pojo.Books;
import com.li.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
//    controller层 调用 service层

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    // 查询全部的书，并且返回书籍展示界面

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

//    跳转到增加书籍界面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

//    添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        bookService.addBook(books);
        return "redirect:/book/allBook"; // 使用重定向
    }

//    跳转到修改页面
    @RequestMapping("/tochangeBook/{id}")  //resful风格
    //@RequestMapping("/tochangeBook") 使用这种方法的时候 将下面方法参数中的 @PathVariable  删除
    public String tochangeBook(@PathVariable("id") int id,Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("qbooks",books);
        return "changeBook";
    }

//    修改书籍的请求  修改失败，问题：没有传入id ，需要提交隐式的bookID
    @RequestMapping("/changeBook")
    public String changeBook(Books books){
        bookService.updateBook(books);
        System.out.println("xiugai=>" + books);
        return "redirect:/book/allBook";
    }

//    删除书籍
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

//    查询书籍
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        List<Books> books = bookService.queryBookName(queryBookName);

        model.addAttribute("list",books);

        return "allBook";
    }

}
