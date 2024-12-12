package com.example.Client_JCDiamante;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient (name = "books-service")
public interface Controller {

    @RequestMapping("/hello")
    String greeting();

    @RequestMapping("/books")
    List<Book> getBooks();

    @RequestMapping("/actuator/info")
    String infoPage();

}
