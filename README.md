HQL Queries
-----------

01) Query query = session.createQuery(" FROM Book WHERE publicationYear > '2010' ");
02) Query updatePrice = session.createQuery("UPDATE Book b SET b.price = b.price + (price * 10/100) where b.author = 'Scott'");
03)
04) Query average = session.createQuery("SELECT AVG(b.price) FROM Book b");
05) Query authosWrittenBooksCount = session.createQuery("SELECT a.name, COUNT(b)\n" +
                "FROM Author a\n" +
                "JOIN a.books b\n" +
                "GROUP BY a.name\n");
07) Done in Author entity and Book entity
10)


Cascade Operation
-----------------

@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)


Annotations
-----------

@Entity - Define that class as an entity
@Id - Define the Primary key
@GeneratedValue - This annotation is generally used in conjunction with @Id annotation to automatically generate unique values for primary key columns within our database tables.
@OneToMany - When there is a one to many relationship
@ManyToOne - Many instances of the entity are mapped to one instance of another entity 
@JoinColumn(name = "author_id") = To specify the mapping of a foreign key column(author_id) in a relationship between two entities. 

