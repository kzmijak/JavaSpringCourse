package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try
		{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception exc)
		{
			System.out.println("\n\nMain Program ... caught exception: " + exc);
		}

		// close the context
		context.close();
	}

}










