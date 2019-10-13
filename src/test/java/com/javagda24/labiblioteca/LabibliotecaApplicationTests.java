package com.javagda24.labiblioteca;

import com.javagda24.labiblioteca.model.Book;
import com.javagda24.labiblioteca.model.PublishingHouse;
import com.javagda24.labiblioteca.model.dto.AddBookRequest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LabibliotecaApplicationTests {

    private final int NUMBER_OF_COPIES = 5;
    private final int NUMBER_OF_PAGES = 300;
    private final int YEAR_WRITTEN = 1990;
    private final String TITLE = "Qvo Vadis";
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads() {
        PublishingHouse publishingHouse = new PublishingHouse();
        publishingHouse.setName("My ph");
        HttpEntity<PublishingHouse> publishingHouseHttpEntity = new HttpEntity<>(publishingHouse);
        ResponseEntity<Long> responseEntityPh = testRestTemplate.exchange("/api/ph", HttpMethod.PUT, publishingHouseHttpEntity, new ParameterizedTypeReference<Long>() {
        });
        Assert.assertEquals(HttpStatus.CREATED, responseEntityPh.getStatusCode());
//        ####################### DODAŁEM PUBLISHING HOUSE

        AddBookRequest addBookRequest = new AddBookRequest(responseEntityPh.getBody(), TITLE, YEAR_WRITTEN, NUMBER_OF_PAGES, NUMBER_OF_COPIES);
        HttpEntity<AddBookRequest> putEntity = new HttpEntity<>(addBookRequest);

        ResponseEntity responseEntity = testRestTemplate.exchange("/api/ph/book", HttpMethod.PUT, putEntity, new ParameterizedTypeReference<Void>() {
        });
        Assert.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        //        ####################### DODAŁEM PUBLISHING HOUSE

        ResponseEntity<List<Book>> books = testRestTemplate.exchange("/api/book/list", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
        });

        Assert.assertFalse(books.getBody().isEmpty());
        Book book = books.getBody().get(0);
        Assert.assertEquals(NUMBER_OF_COPIES, book.getNumberOfCopies());
        Assert.assertEquals(NUMBER_OF_PAGES, book.getNumberOfPages());
        Assert.assertEquals(TITLE, book.getTitle());
        Assert.assertEquals(YEAR_WRITTEN, book.getYearWritten());
    }

}
