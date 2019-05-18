package com.example.books.model.book;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BookController {

    @Autowired
    private RestTemplate bookRestTemplate;

    @RequestMapping("/searchBooks")
    public ResponseEntity<?> searchBooks(@RequestParam(value="query") String query) throws JsonProcessingException {

        String uri = String.format("https://www.googleapis.com/books/v1/volumes?q=%s", query);
        String responseBody = bookRestTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<>(getHeaders()), String.class).getBody();
       
        return ResponseEntity.ok(responseBody);
    }

    @RequestMapping("/test")
    public ResponseEntity<?> greeting(@RequestParam(value="name", defaultValue="World") String name) {

        
        return ResponseEntity.ok("ola");
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}