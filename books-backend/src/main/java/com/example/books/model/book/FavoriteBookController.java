package com.example.books.model.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins = "*")
@RestController
public class FavoriteBookController {

    @Autowired
    private RestTemplate bookRestTemplate;

    @Autowired
    private FavoriteBookRepository favoriteBookRepository;

    @GetMapping("/favoriteBooks")
    public List<FavoriteBook> all() {
        return favoriteBookRepository.findAll();
    }

    @PostMapping("/favoriteBooks")
    public ResponseEntity<FavoriteBook> createFavoriteBook (@Valid @RequestBody FavoriteBook favoriteBook) {
        return ResponseEntity.ok(favoriteBookRepository.save(favoriteBook));
    }

    @PutMapping("/favoriteBooks/{id}")
    public ResponseEntity<FavoriteBook> updateFavoriteBook(@Valid @RequestBody FavoriteBook favoriteBook,
        @PathVariable(value= "id") Long id) {
            favoriteBook.setId(id);
            return ResponseEntity.ok(favoriteBookRepository.save(favoriteBook));
        }

    @DeleteMapping("/favoriteBooks/{id}")
    public ResponseEntity<?> deleteFavoriteBook(@PathVariable Long id) {
        Map<String,String> response = new HashMap<String,String>();
        FavoriteBook favoriteBook = favoriteBookRepository.findById(id).orElse(null);
    
        if(favoriteBook != null) {
            favoriteBookRepository.delete(favoriteBook);
            response.put("status", "success");
            response.put("message", "favoriteBook deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "error");
            response.put("message", "Somthing went wrong when delete the favoriteBook");
            return ResponseEntity.status(500).body(response);
        }
    }

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