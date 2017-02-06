package should;

import com.bankkata.Console;
import com.bankkata.StatementPrinter;
import com.bankkata.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;

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
        statementPrinter = new StatementPrinter();
    }

    @Test
    public void always_print_the_header(){
        statementPrinter.print(Collections.EMPTY_LIST);

        //whatever the transactions, we should print a header, meaning send a header to Console's printLine
        verify(console).printLine("DATE | AMOUNT | BALANCE");

    }
}
