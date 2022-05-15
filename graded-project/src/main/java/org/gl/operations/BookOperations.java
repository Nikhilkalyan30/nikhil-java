package org.gl.operations;

import java.util.List;

import javax.persistence.Query;

import org.gl.helper.AppConst;
import org.hibernate.Session;

import org.gl.helper.FactoryProvider;
import org.gl.model.Book;

public class BookOperations {
	
	
	public static void displayBiographyBooks()
	{
		
		System.out.println("Auto Biography Book Information");
		System.out.println();
		 Session session = FactoryProvider.getFactory().openSession();
			Query query = session.createQuery("From Book where genre='"+"Auto Biography"+"'");
			List<Book> list = query.getResultList(); 
			if(list.size()>0) {
			  for (Book book : list) {
		             System.out.println("Book Id: " + book.getBookId() + " Book name: " + book.getBookName());

		        }}
			else
			{
				
				System.out.println("As of now no Auto Biography are there");
			}
			System.out.println();
	        session.close();
		
	}

	public static void showAllBooks()
	{
		Session session = null;
   	 	session = FactoryProvider.getFactory().openSession();
        Query q = session.createQuery("From Book");
        List<Book> list = q.getResultList();
        for (Book book : list) {
            System.out.println("Book Id: " + book.getBookId() + " Book name: " + book.getBookName());

        }
    	System.out.println();
        session.close();
	}
	
	 public static void ascendingOrder() {
		 System.out.println("Book According to price Low to High");
		 System.out.println();
	     Session session=FactoryProvider.getFactory().openSession();
	     Query q = session.createQuery("From Book b ORDER BY b.price ASC");
	     List<Book> list = q.getResultList();
	     for (Book book : list) {
	         System.out.println(book.getBookName() +"\t"+ " Price: "
	                    + book.getPrice());
	            
	     }
	 	 System.out.println();
	     session.close();
	 }
	 
	 public static void bestSelling()
	 {
		 System.out.println("Best Selling book Information");
		 System.out.println();
		 Session session = null;
		 session = FactoryProvider.getFactory().openSession();
		 
		 String query = "Select max(b.sell) From Book b";
		
		 List list = session.createQuery(query).list();
		 
		 int maxSold = (Integer)list.get(0);
		 
		 Query sqlQuery = session.createQuery("From Book where sell='"+maxSold+"'");
		 List<Book> books = sqlQuery.getResultList();
		 
		 
		 for (Book book : books) {
			 System.out.println();
		       System.out.println("Book name:-"+book.getBookName());
		       System.out.println("Book Genre:-"+book.getGenre());
		       System.out.println("Book Author:-"+book.getAuthorName());
		       System.out.println("Book description:-"+book.getDescription());
		       System.out.println("Book Price:-"+book.getGenre());
		       System.out.println("number of Copies sold:-"+book.getSell());
		       
		  }
		  System.out.println();
		  session.close();
			
	 }
	 
	 public static void descendingOrder() {
		 System.out.println("Book According to price High to Low");
		 System.out.println();
	     Session session=FactoryProvider.getFactory().openSession();
	     Query q = session.createQuery("From Book b ORDER BY b.price DESC");
	     List<Book> list = q.getResultList();
	     for (Book book : list) {
	         System.out.println(book.getBookName() +"\t"+ " Price: "
	                    + book.getPrice());
	            
	     }
	     System.out.println();
	     session.close();
	 }
	 
	public static int countBooks()
	{
		 Session session = FactoryProvider.getFactory().openSession();
	        Query q = session.createQuery("From Book");
	        List<Book> list=q.getResultList();
	        session.close();
	        System.out.println();
	        return list.size();
	}
	public static void start()
	{
		
		String opinion;
		do {
		System.out.println("************** MENU ***********");
		
		System.out.println();
		System.out.println("1. Display Book count");
		System.out.println("2. Display via Genre");
		System.out.println("3. Book Information");
		System.out.println("4. Arrange price low to high");
		System.out.println("5. Arrange price high to low");
		System.out.println("6. Arrange best selling on Top");
		System.out.println();
		
		System.out.println("Please enter your choice");
		int choice = AppConst.scanner.nextInt();
		
		switch(choice)
		{
			case 1:
				System.out.println("Total number of Book "+countBooks());
				break;
			case 2:
				displayBiographyBooks();
				break;
			case 3:
				showAllBooks();
				break;
			case 4:
				ascendingOrder();
				break;
			case 5:
				descendingOrder();
				break;
			case 6:
				bestSelling();
				break;
		}
		
		System.out.println("Do you want to continue?");
		opinion = AppConst.scanner.next();
		
		}while(opinion.equalsIgnoreCase("Yes"));
		
		System.out.println("Press 1 from Main Menu and 0 For Exit!");
		opinion =  AppConst.scanner.next();
		if(opinion.equals("0"))
		{
			System.out.println("Thank You !");
			System.exit(1);
		}
	}
}
