package com.bankkata;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by ryan on 06/02/2017.
 */
public class StatementPrinter {

    private Console console;
    private String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";
    private DecimalFormat decimalFormatter = new DecimalFormat("#.00");

    public StatementPrinter(Console console){
        this.console = console;
    }
    public void print(List<Transaction> transactions){
        console.printLine(STATEMENT_HEADER);
        printStatementLines(transactions);
    }

    /**
     * This way of doing the statement lines is a bit unusual as far as traditional java code goes.
     * It maps transactions to statement lines by going through transactions in reverse order (descendingIterator).
     * As it goes it does a running total using an AtomicInteger, which supports concurrent access (since the map-collect can run in multiple threads).
     * See http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/ on streams/map-collect
     * See http://stackoverflow.com/questions/4818699/practical-uses-for-atomicinteger on AtomicInteger
     * @param transactions
     */
    private void printStatementLines(List<Transaction> transactions) {
        AtomicInteger runningBalance = new AtomicInteger(0);
        transactions.stream()
                .map(transaction -> statementLine(transaction,runningBalance))
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(console::printLine);
    }

    private String statementLine(Transaction transaction, AtomicInteger runningBalance){
        return transaction.getDate()
                + " | "
                + decimalFormatter.format(transaction.getAmount())
                + " | "
                + decimalFormatter.format(runningBalance.addAndGet(transaction.getAmount()));
    }
}
