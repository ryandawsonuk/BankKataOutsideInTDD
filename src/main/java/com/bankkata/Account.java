package com.bankkata;

/**
 * Created by ryan on 05/02/2017.
 */
public class Account {

    StatementPrinter statementPrinter;

    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository, StatementPrinter statementPrinter){
        this.transactionRepository = transactionRepository;
        this.statementPrinter = statementPrinter;
    }

    public void deposit(int amount){
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount){
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement(){
        statementPrinter.print(transactionRepository.allTransactions());
    }
}
