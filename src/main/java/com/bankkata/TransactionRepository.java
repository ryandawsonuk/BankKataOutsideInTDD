package com.bankkata;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

/**
 * Created by ryan on 05/02/2017.
 */
public class TransactionRepository {

    private final Clock clock;
    private List<Transaction> transactions = new ArrayList<Transaction>();

    public TransactionRepository(Clock clock){
        this.clock = clock;
    }

    public void addDeposit(int amount){
        Transaction depositTransaction = new Transaction(clock.dateAsString(), amount);
        transactions.add(depositTransaction);
    }

    public void addWithdrawal(int amount){
        throw new UnsupportedOperationException();
    }

    public List<Transaction> allTransactions(){
        return unmodifiableList(transactions);
    }
}
