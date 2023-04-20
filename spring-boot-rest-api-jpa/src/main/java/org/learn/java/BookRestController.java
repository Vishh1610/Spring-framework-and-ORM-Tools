package org.learn.java;

import io.swagger.annotations.ApiOperation;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rest")
public class BookRestController {

    @Autowired
    BookRepository bookRepository;

    //List<Book> books = BookRepository.BOOKS;
    //Map<Integer, Book> bookMap = BookRepository.BOOKMAP;

    //Restfull API where we can perform CRUD operations - create/post, read/get, update/put, delete

    @ApiOperation(value = "Get all the books item, returns array of book")
    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    //public ResponseEntity<List<Book>> getAll()
    public ResponseEntity<Collection<Book>> getAll(){
        return new ResponseEntity<Collection<Book>>(bookRepository.findAll(), HttpStatus.OK);

        //SELECT * FROM BOOK
    }

    @ApiOperation(value = "Get one books by id, returns a book")
    @GetMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> getOne(@PathVariable Integer id){
        Book book = bookRepository.findOne(id);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @ApiOperation(value = "Create a book, add book in request body, returns void")
    @PostMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> createOrAdd(@RequestBody(required = true) Book book){
        //books.add(book);
       // bookMap.put(book.getId(), book);
        bookRepository.save(book);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an existing book ,and book for update in the request body, returns updated book")
    @PutMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> update(@RequestBody(required = true) Book book){
        if(book.getId() != null){
         book = bookRepository.save(book);
        } else {
            return createOrAdd(book);
        }
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a books by id, returns void")
    @DeleteMapping(value = "/books/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id){
      bookRepository.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
