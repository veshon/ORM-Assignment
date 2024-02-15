package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(" FROM Book WHERE publicationYear > '2010' ");

       // Query updatePrice = session.createQuery("UPDATE Book b SET b.price = b.price + (price * 10/100) where b.author = 'Scott'");

        //  Query average = session.createQuery("SELECT AVG(b.price) FROM Book b");

       /* Query authosWrittenBooksCount = session.createQuery("SELECT a.name, COUNT(b)\n" +
                "FROM Author a\n" +
                "JOIN a.books b\n" +
                "GROUP BY a.name\n");*/

        List<Book> books=query.list();        // Books After 2010
        for (Book b:books) {
            System.out.println(b.getTitle());
        }

    /*    List<Book> books=updatePrice.list();   // Update Price
        for (Book b:books) {
            System.out.println(b.getPrice());
        }*/
/*
        List<Book> books=average.list();   // Average Price
        for (Book b:books) {
            System.out.println(b.getPrice());
        }*/

/*        List<Author> authors=authosWrittenBooksCount.list();   //authosWrittenBooksCount
        for (Author a:authors) {
            System.out.println(a.getName());
        }*/


/*

        Book book1 = new Book();
        book1.setId("B001");
        book1.setPrice(1000);
        book1.setPublicationYear("2020");
        book1.setTitle("The Great Gatsby");

        Book book2 = new Book();
        book2.setId("B002");
        book2.setPrice(1000);
        book2.setPublicationYear("2022");
        book2.setTitle("Harry Potter");

        Book book3 = new Book();
        book3.setId("B003");
        book3.setPrice(1500);
        book3.setPublicationYear("2023");
        book3.setTitle("Happy Place");

        Author author1 = new Author();
        author1.setId("A001");
        author1.setName("Scott");
        author1.setCountry("USA");

        Author author2 = new Author();
        author2.setId("A002");
        author2.setName("Emily Henry");
        author2.setCountry("USA");

        Author author3 = new Author();
        author3.setId("A003");
        author3.setName("Ben");
        author3.setCountry("USA");

        List<Book>bookList=new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        session.save(author1);
        session.save(author2);
        session.save(author3);

        session.save(book1);
        session.save(book2);
        session.save(book3);

        book1.setAuthor(author1);
        book2.setAuthor(author2);
        book3.setAuthor(author3);
*/

        transaction.commit();
        session.close();

    }
}