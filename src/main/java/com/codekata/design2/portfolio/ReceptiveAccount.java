/*
 * Developed by 10Pines SRL
 * License: 
 * This work is licensed under the 
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License. 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-sa/3.0/ 
 * or send a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, 
 * California, 94041, USA.
 *  
 */
package com.codekata.design2.portfolio;

import java.util.ArrayList;
import java.util.List;

public class ReceptiveAccount implements SummarizingAccount {

	private List<AccountTransaction> transactions = new ArrayList<>();

	public double balance() {
		double balance =0D;
		for (AccountTransaction accountTransaction: transactions
				 ) {
			balance+=accountTransaction.value();

		}
		return balance;
	}

	public void register(AccountTransaction transaction) {
		transactions().add(transaction);
	}

	public boolean registers(AccountTransaction transaction) {
		return this.transactions().contains(transaction);
	}

	public boolean manages(SummarizingAccount account) {
		return account.equals(this);
	}
	
	public List<AccountTransaction> transactions() {
		return this.transactions;
	}

}
