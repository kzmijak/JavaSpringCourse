package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

	}

	public List<Account> findAccounts()
	{
		List<Account> accounts = new ArrayList<>();

		// create sample accounts

		// add them to our account list

		Account temp1 = new Account("John", "Silver");
		Account temp2 = new Account ( "Madhu", "Platinum");
		Account temp3 = new Account("Luca", "Gold");

		accounts.add(temp1);
		accounts.add(temp2);
		accounts.add(temp3);


		return accounts;
	}

	public void giveInteger(int integer)
	{
		System.out.println("Yes very nice");
	}
}
