package com.example.books.model.book;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @RequestMapping("/test")
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return ResponseEntity.ok("ola");
    }
}