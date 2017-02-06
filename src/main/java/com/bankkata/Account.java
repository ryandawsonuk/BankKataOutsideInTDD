package com.bankkata;

/**
 * Created by ryan on 05/02/2017.
 */
public class Account {

    private TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount){
        transactionRepository.addDeposit(amount);
    }

    public void withdraw(int amount){
        transactionRepository.addWithdrawal(amount);
    }

    public void printStatement(){

    }
}
