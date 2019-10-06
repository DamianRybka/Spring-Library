package com.javagda24.labiblioteca.controller;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.service.BookService;
import com.javagda24.labiblioteca.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/book/")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private PublishingHouseService publishingHouseService;


    @GetMapping("/list")
    public String list(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);

        return "book-list";
    }

    @GetMapping("/add")
    public String bookAddForm(Model model, Book book){
        model.addAttribute("edited_book", book);
        model.addAttribute("allPublishingHouses", publishingHouseService.getAll());

        return "book-form";
    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam(name = "bookId") Long id) {
        Optional<Book> bookOptional = bookService.getById(id);
        if(bookOptional.isPresent()) {
            model.addAttribute("edited_book", bookOptional.get());
            model.addAttribute("allPublishingHouses", publishingHouseService.getAll());
            return "book-form";
        }
        return "redirect:/book/list";
    }

    @PostMapping("/add")
    public String saveBook(Book book, Long publishingHouseId){
        bookService.save(book, publishingHouseId);

        return "redirect:/book/list";
    }
}
