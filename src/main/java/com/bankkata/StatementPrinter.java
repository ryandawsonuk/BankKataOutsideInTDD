package com.bankkata;

import java.util.List;

/**
 * Created by ryan on 06/02/2017.
 */
public class StatementPrinter {

    private Console console;
    private String STATEMENT_HEADER = "DATE | AMOUNT | BALANCE";

    public StatementPrinter(Console console){
        this.console = console;
    }
    public void print(List<Transaction> transactions){
        console.printLine(STATEMENT_HEADER);
    }
}
