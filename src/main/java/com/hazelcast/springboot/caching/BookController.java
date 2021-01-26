package com.hazelcast.springboot.caching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/cache/{isbn}")
    public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookNameByIsbn(isbn);
    }

//    @GetMapping("/test")
//    public String testingAja(){
//        List<String> list = new ArrayList<>();
//        list.add("Ikhbar");
//        list.add("Muktamar");
//        list.add("Sidik");
//        String[] str = list.stream().toArray(i -> new String[i]);
//        for(int i=0; i<str.length; i++){
//            System.out.println(str[i]);
//        }
//        String res = String.join(" ",str);
//        return res;
//    }
//
//    @GetMapping("zip")
//    public String zipCollection(){
//        List<String> list = new ArrayList<>();
//        Flux.just(1,2,3,4)
//                .map(i -> i*i)
//                .zipWith(Flux.range(0,2),(one , two) -> String.format("First %d, Second %d", one, two))
//                .subscribe(list::add);
//
//        list.forEach(s -> System.out.println(s));
//        return "done";
//    }
}

