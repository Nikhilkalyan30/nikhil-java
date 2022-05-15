package org.gl.dao;

import java.util.List;

import javax.persistence.Query;

import org.gl.exceptions.BookNotFoundException;
import org.gl.helper.AppConst;
import org.gl.helper.FactoryProvider;
import org.gl.model.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class BookDao {

    public void addBook() {
    	System.out.println();
    	System.out.println("Enter Book name");
  
    	String bookName = AppConst.scanner.nextLine();
    	
    	System.out.println("Enter Book Genre");
    	String genre = AppConst.scanner.nextLine();
    	
    	System.out.println("Enter Book Author");
    	String authorName = AppConst.scanner.nextLine();
    	
    	System.out.println("Enter Book description");
    	String description = AppConst.scanner.nextLine();
    	
    	System.out.println("Enter Book Price");
    	double price = AppConst.scanner.nextDouble();
    	
    	System.out.println("Enter the number of Copies sold");
    	int sell = AppConst.scanner.nextInt();
    	
        Book book = new Book(bookName, authorName, description, price, genre ,sell);
        Session session = FactoryProvider.getFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(book);
        tx.commit();
        System.out.println("Book added");
        System.out.println();
        session.close();
    }

    public void deleteBook() {
    	System.out.println();
    	 Session session = null;
    	 session = FactoryProvider.getFactory().openSession();
         Query q = session.createQuery("From Book");
         List<Book> list = q.getResultList();
         for (Book book : list) {
             System.out.println("Book Id: " + book.getBookId() + " Book name: " + book.getBookName());

         }
         
         Transaction tx = session.beginTransaction();
         System.out.println("Please Enter the Book name id you want to delete");
         int bookId = AppConst.scanner.nextInt();
         Book book = session.get(Book.class, bookId);
         try {
        	 if(book==null) {
                throw new BookNotFoundException("Book not found!");
            }
           session.delete(book);
           tx.commit();
           System.out.println("Book Deleted");
           System.out.println();
           session.close();
            
        } catch (BookNotFoundException e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void updateBook() {
    	System.out.println();
    	 Session session = null;
    	 session = FactoryProvider.getFactory().openSession();
         Query q = session.createQuery("From Book");
         List<Book> list = q.getResultList();
         for (Book book : list) {
             System.out.println("Book Id: " + book.getBookId() + " Book name: " + book.getBookName());

         }
         
         Transaction tx = session.beginTransaction();
         System.out.println("Please Enter the Book name id you want to update");
         int bookId = AppConst.scanner.nextInt();
         Book book = session.get(Book.class, bookId);
         try {
             if( book == null) {
                 throw new BookNotFoundException("Book not found!");
             }
             System.out.println("Please Enter new information");
             
             System.out.println("Enter Book Price");
             double price = AppConst.scanner.nextDouble();
             book.setPrice(price);
             
             System.out.println("Enter number of copies sold");
             int sell = AppConst.scanner.nextInt();
             book.setSell(sell);
             
             session.update(book);
             tx.commit();
             System.out.println("Book Updated!");
             System.out.println();
             session.close();

         } catch (BookNotFoundException e) {
             System.out.println(e);
         }


    }

}
