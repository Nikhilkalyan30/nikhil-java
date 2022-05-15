package org.gl.week4.graded_project;

import org.gl.dao.BookDao;
import org.gl.helper.AppConst;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.gl.helper.FactoryProvider;
import org.gl.operations.BookOperations;
import org.gl.config.MongoConfig;
import org.gl.repository.TicketRepository;

public class App {
  public static void main(String[] args) {
	
	System.out.println("Please enter your Role(Admin/User)");
	String role=AppConst.scanner.next();
	if(!role.equals("Admin")) {
	do
	{
		System.out.println("Invalid Role!");
		System.out.println("Please reEnter");
		System.out.println("Please enter your Role(Admin/User)");
		role=AppConst.scanner.next();
	}while(!role.equals("Admin"));}
	else
	{
		ApplicationContext appContext = new AnnotationConfigApplicationContext(MongoConfig.class);

        TicketRepository ticketRepository = appContext.getBean(TicketRepository.class);
	}
	BookDao dao = new BookDao();
	String userChoice;
	
	do
	{
		
		System.out.println("************** MENU ***********");
		System.out.println();
		System.out.println("1. Add a Book");
		System.out.println("2. Delete a Book");
		System.out.println("3. Update a Book");
		System.out.println("4. Display the Books");
		
		System.out.println();
		System.out.println();
		
		System.out.println("Please enter your choice");
		int choice = AppConst.scanner.nextInt();
	  	AppConst.scanner.nextLine();
	  	
		switch(choice)
		{
		case 1:
			dao.addBook();
			break;
		case 2:
			dao.deleteBook();
			break;
		case 3:
			dao.updateBook();
			break;
		case 4:
			BookOperations opt = new BookOperations();
			opt.start();
			break;
		}
		
		System.out.println("Do you want to continue?");
		
		userChoice=AppConst.scanner.next();
	}while(userChoice.equalsIgnoreCase("Yes"));
  }
}
