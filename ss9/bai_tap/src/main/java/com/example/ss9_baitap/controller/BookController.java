package com.example.ss9_baitap.controller;

import com.example.ss9_baitap.error.QuantityZero;
import com.example.ss9_baitap.error.WrongCodeRent;
import com.example.ss9_baitap.model.Book;
import com.example.ss9_baitap.model.Rent;
import com.example.ss9_baitap.service.IBookService;
import com.example.ss9_baitap.service.IRentService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IRentService rentService;

    @GetMapping("")
    public String goLibrary(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "library";
    }

    @SneakyThrows
    @GetMapping("rent/{id}")
    public String rentBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        Optional<Book> book = bookService.findById(id);
        assert book.isPresent();
        if (book.get().getQuantity() > 0) {
            book.get().setQuantity(book.get().getQuantity() - 1);
            bookService.save(book.get());
            redirectAttributes.addFlashAttribute("message", "rent success");
            return "redirect:/";
        }
        if (book.get().getQuantity() <= 0) throw new QuantityZero("this book was rent empty");
        return "redirect:/";
    }

    @GetMapping("/listRent")
    public String ListRent(Model model) {
        model.addAttribute("listRent", rentService.findAll());
        return "library";
    }

    @SneakyThrows
    @GetMapping("pay")
    public String returnBook(@RequestParam("idReturn") Long idReturn, RedirectAttributes redirectAttributes) {

        Optional<Rent> rent = rentService.findById(idReturn);
        if (rent.isPresent()) {
            rent.get().setStatus("off");
            rentService.save(rent.get());
            Book book = bookService.findById(rent.get().getBook().getId()).get();
            book.setQuantity(book.getQuantity() + 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("message", "rent success");

        }
        if (!rent.isPresent()){
            throw new WrongCodeRent("Wrong code input again");

        }
        return "redirect:/";
    }


}
