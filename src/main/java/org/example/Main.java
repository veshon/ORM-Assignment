package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

/*
        Query query=session.createQuery("from Author ");

        List<Author> authorList=query.list();
        for (Author a:authorList) {
            System.out.println(a.getName());
        }
*/

        Author author = new Author();
        author.setId("a001");
        author.setName("Scott");

        Author author1 = new Author();
        author1.setId("a002");
        author1.setName("Ben");

        Book book = new Book();
        book.setId("b001");
        book.setPrice("1000");
        book.setPublicationYear("2020");
        book.setTitle("The Great Gatsby");

        Book book1 = new Book();
        book1.setId("b002");
        book1.setPrice("1000");
        book1.setPublicationYear("2022");
        book1.setTitle("Harry Potter");

        session.save(author);
        session.save(author1);
        session.save(book);

        transaction.commit();
        session.close();

    }
}