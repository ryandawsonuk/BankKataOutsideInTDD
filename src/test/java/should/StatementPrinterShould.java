package should;

import com.bankkata.Console;
import com.bankkata.StatementPrinter;
import com.bankkata.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;

/**
 * Created by ryan on 06/02/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class StatementPrinterShould {

    private StatementPrinter statementPrinter;
    @Mock Console console;

    @Before
    public void intiialise(){
        statementPrinter = new StatementPrinter(console);
    }

    @Test
    public void always_print_the_header(){
        statementPrinter.print(Collections.EMPTY_LIST);

        //whatever the transactions, we should print a header, meaning send a header to Console's printLine
        verify(console).printLine("DATE | AMOUNT | BALANCE");

    }

    @Test
    public void print_transaction_in_reverse_chronological_order(){

        //create transactions to use for test
        //best to do this with helper methods
        List<Transaction> transactionList = transactionsContaining(
             deposit("01/04/2014",1000),
             withdrawal("02/04/2014", 100),
             deposit("10/04/2014", 500)
        );

        statementPrinter.print(transactionList);


        // test for ordering just as we did in PrintStatementFeature
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");

    }

    private List<Transaction> transactionsContaining(Transaction... transactions) {
        return Arrays.asList(transactions);
    }

    private Transaction deposit(String date, int amount) {
        return new Transaction(date,amount);
    }

    private Transaction withdrawal(String date, int amount) {
        return new Transaction(date,-amount);
    }
}
