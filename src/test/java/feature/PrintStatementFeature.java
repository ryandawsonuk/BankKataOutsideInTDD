package feature;

import org.junit.Test;
import static org.mockito.Mockito.verify;

/**
 * Created by ryan on 04/02/2017.
 * We start by creating an acceptance test. This is PrintStatementFeature.
 */
public class PrintStatementFeature {

    /**
     * The main thing we know is the format of the statement - it's the obvious side-effect to test for.
     * So we start with print_statement_containing_all_transactions.
     * We remove some whitespace in the statements to make them neater.
     */
    @Test public void print_statement_containing_all_transactions(){
        verify(console).printLine("DATE | AMOUNT | BALANCE");
        verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
