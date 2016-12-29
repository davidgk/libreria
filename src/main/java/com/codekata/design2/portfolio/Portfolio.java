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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

public class Portfolio implements SummarizingAccount{

	public static final String ACCOUNT_NOT_MANAGED = "No se maneja esta cuenta";
	public static final String ACCOUNT_ALREADY_MANAGED = "La cuenta ya está manejada por otro portfolio";
	private Map<SummarizingAccount, SummarizingAccount> accounts;


	public static Portfolio createWith(SummarizingAccount anAccount1, SummarizingAccount anAccount2) {
		Portfolio portfolio = new Portfolio();
		portfolio.addAccount(anAccount1);
		portfolio.addAccount(anAccount2);
		return portfolio;
	}




	public Portfolio(){
		this.accounts = new HashMap<>();
	}
	
	public double balance() {
		double balance = 0D;
		for (SummarizingAccount summarizingAccount: this.accounts.keySet()) {
			balance += this.accounts.get(summarizingAccount).balance();
		}
		return balance;
	}

	public boolean checkOverAccounts(AccountTransaction accountTransaction, BiFunction<SummarizingAccount,AccountTransaction, Boolean > logicApplyed){
		for (SummarizingAccount summarizingAccount: this.accounts.keySet()) {
			if (logicApplyed.apply(summarizingAccount, accountTransaction)) return true;
		}
		return false;
	}


	public boolean registers(AccountTransaction transaction) {
		BiFunction<SummarizingAccount,AccountTransaction, Boolean > isRegisteredFunction = (account, transactionToCheck) -> {return this.accounts.get(account).registers(transactionToCheck);};
		boolean isRegistered = checkOverAccounts(transaction, isRegisteredFunction);
		return isRegistered;
	}

	public List<AccountTransaction> transactionsOf(SummarizingAccount account) {
		return this.accounts.get(account).transactions();
	}
	
	public boolean manages(SummarizingAccount account) {
		BiFunction<SummarizingAccount,AccountTransaction, Boolean > isRegisteredFunction = (accountValue, transactionToCheck) ->
		{
			try {
				if(((Portfolio) accountValue).manages(accountValue)){
					return true;
				}
			}catch (Exception e){
				return false;
			}
			return false;
		};
		if (!isAccountIsAlreadyManaged(account)){
			boolean isRegistered =  checkOverAccounts(null, isRegisteredFunction);
			return isRegistered;
		}
		return true;

	}
	
	public List<AccountTransaction> transactions() {
		List<AccountTransaction> transactions = new ArrayList<>();
		for (SummarizingAccount cuenta: this.accounts.keySet()){
			if(cuenta instanceof Portfolio){
				Portfolio portfolio = (Portfolio) this.accounts.get(cuenta);
				transactions.addAll(portfolio.transactions());
			}else{
				transactions.addAll(cuenta.transactions());
			}
		}
		return transactions;
	}

	public void addAccount(SummarizingAccount anAccount) {
		if(isAccountIsAlreadyManaged(anAccount)){
			throw new RuntimeException(Portfolio.ACCOUNT_ALREADY_MANAGED);
		}
		this.accounts.putIfAbsent(anAccount, anAccount);
	}

	private boolean isAccountIsAlreadyManaged(SummarizingAccount anAccount) {
		if(!this.accounts.containsKey(anAccount) ){
			for (SummarizingAccount account: this.accounts.keySet()
					 ) {
				if(account instanceof  Portfolio){
					Portfolio portfolio = (Portfolio) this.accounts.get(account);
					if(portfolio.manages(anAccount)){
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}

}
