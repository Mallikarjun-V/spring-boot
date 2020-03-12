package com.learn.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.SpringBootHibernateApplication;
import com.learn.dto.Book;
import com.learn.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { SpringBootHibernateApplication.class })
@WebAppConfiguration
@ActiveProfiles("test")
public class BookControllerTest {
    
    @Autowired
    private WebApplicationContext webAppContext;
    private MockMvc               mockMvc;
    
    @MockBean
    private BookService bookService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }
    
    @Test
    public void whenBookGETAllisPerformed_thenReturnAll() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("MyBook1"));
        books.add(new Book("MyBook2"));
        given(this.bookService.list()).willReturn(books);
        
        mockMvc.perform(get("/books")).andExpect(status().isOk()).andDo(print())
                .andExpect(content().contentType("application/json")).andExpect(jsonPath("$[0].name").value("MyBook1"))
                .andExpect(jsonPath("$[1].name").value("MyBook2")).andDo(print());
    }
    
    @Test
    public void whenBookGETByNameisPerformed_thenRetrievedStatusisCorrect() throws Exception {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("MyBook"));
        given(this.bookService.findByName("MyBook")).willReturn(books);
        
        mockMvc.perform(get("/books").param("name", "MyBook").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].name").exists()).andExpect(jsonPath("$[0].name").value("MyBook"))
                .andDo(print());
    }
    
    @Test
    public void whenBookAddisPerformed_thenReturnAddedEntry() throws Exception {
        Book book = new Book("YourBook");
        given(this.bookService.save(any(Book.class))).willReturn(book);
        
        mockMvc.perform(post("/books").content(asJsonString(book)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").exists()).andDo(print());
    }
    
    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webAppContext.getServletContext();
        
        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webAppContext.getBean("bookController"));
    }
    
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
